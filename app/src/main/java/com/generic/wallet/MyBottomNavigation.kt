package com.generic.wallet


import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.Shape
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.marginBottom
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarItemView
import kotlinx.coroutines.*


class BottomNavigationCircles : BottomNavigationView {
    private val LOG_TAG = "BottomNavigationCircles"

    private var currentNavigationItemId = -1
    private var currentCircleId = -1
    private val menuViewGroupId = View.generateViewId()

    private lateinit var rootLayout: RelativeLayout
    private var enabledColor = Color.RED


    private fun buildBackgroundCircle(): ImageView {

        val circleView = AppCompatImageView(context)
        circleView.id = View.generateViewId()
        val shapeDrawable = ShapeDrawable()
        shapeDrawable.shape = OvalShape()



        shapeDrawable.paint.setShadowLayer(
            10f, 0f, -5f, ContextCompat.getColor(context, com.example.sample01.R.color.drop_shadow)
        )


        shapeDrawable.paint.color = ContextCompat.getColor(context, R.color.white)
        val drawable = LayerDrawable(arrayOf<Drawable>(shapeDrawable))
//        val inset = 5
//        drawable.setLayerInset(
//            0, inset, 0, inset, inset
//        )
        circleView.background = drawable
        return circleView
    }


    enum class Shape(val value: Int) {
        Circle(0), RoundedRectangle(1);
    }
    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet? = null) {
//        getBackgroundDrawable()
        setupRootLayout()
        setupListener()
        setupClipping()
        selectFirstItem()
    }


    private fun setupRootLayout() {
        val menuViewGroup = getChildAt(0) as BottomNavigationMenuView
        menuViewGroup.id = menuViewGroupId
        rootLayout = RelativeLayout(context)
        removeView(menuViewGroup)
        rootLayout.addView(menuViewGroup)
        addView(rootLayout)
    }


    private fun setupListener() {
        setOnItemSelectedListener {
            return@setOnItemSelectedListener animateBottomIcon(it.itemId)
        }
    }

    private fun setupClipping() {
        viewTreeObserver.addOnGlobalLayoutListener {
            clipChildren = false
            rootLayout.clipChildren = false
            findViewById<BottomNavigationMenuView>(menuViewGroupId).clipChildren = false
            disableClipOnParents(this)
        }
    }

    private fun disableClipOnParents(view: View) {
        if (view is ViewGroup) {
            view.clipChildren = false
        }
        if (view.parent is View) {

            disableClipOnParents(view.parent as View)
        }

    }

    private fun selectFirstItem() {
        if (rootLayout.childCount > 0 && ((rootLayout.getChildAt(0)) as BottomNavigationMenuView).childCount > 0) {
            val navigationItemView =
                ((rootLayout.getChildAt(0) as BottomNavigationMenuView).getChildAt(0) as NavigationBarItemView)

            navigationItemView.viewTreeObserver.addOnGlobalLayoutListener {
                animateBottomIcon(selectedItemId)
            }
        }
    }


    private fun animateBottomIcon(itemId: Int): Boolean {

        if (itemId != currentNavigationItemId) {
            val itemView = getNavigationBarItemView(itemId)

            val icon = getAppCompatImageView(itemView)
//            ContextCompat.getDrawable(context, R.drawable.bottom_nav_item_background)
            disableClipOnParents(icon)
            val subText = getSubTextView(itemView)
            val animatorSet = AnimatorSet()

            setSubTextStyle(subText)
            // Navigate previous selection out
            if (currentNavigationItemId != -1) {

                val currentItemView = getNavigationBarItemView(currentNavigationItemId)
                val currentView = getAppCompatImageView(currentItemView)
                val oldCircle = rootLayout.findViewById<ImageView>(currentCircleId)

//                currentView.drawable.setTint(Color.GREEN)

                animatorSet.playTogether(
                    buildTranslateIconAnimator(currentView,from= -(height / 4).toFloat()),
                    buildTranslateCircleAnimator(oldCircle, -(height / 4).toFloat())
//                    buildTintAnimator(currentView, enabledColor, disabledColor)
                )
                oldCircle.animate().alpha(0F).duration = 500

                GlobalScope.launch {
                    delay(500)
                    withContext(Dispatchers.Main) {
                        rootLayout.removeView(oldCircle)
                    }
                }
            }

            // Navigate new selection in
            val circleView = buildBackgroundCircle()
            currentCircleId = circleView.id
            rootLayout.addView(circleView)
            findViewById<BottomNavigationMenuView>(menuViewGroupId).bringToFront()
            setCircleSizeAndPosition(
                circleView, subText.height, (icon.width * 3), itemView.x, itemView.width
            )

            animatorSet.playTogether(
                buildTranslateIconAnimator(icon, 0f, -(height / 2.5).toFloat()),
                buildTranslateCircleAnimator(circleView,  -(height / 2.5).toFloat())
//                buildTintAnimator(icon, disabledColor, enabledColor)
            )
            circleView.animate().alpha(1F).duration = 500

            currentNavigationItemId = itemId
            animatorSet.start()
        }
        return true
    }

    private fun getNavigationBarItemView(itemId: Int): NavigationBarItemView {
        return findViewById(itemId)
    }

    private fun getAppCompatImageView(itemView: NavigationBarItemView): AppCompatImageView {
        return itemView.findViewById(
            com.google.android.material.R.id.navigation_bar_item_icon_view
        )
    }

    private fun getSubTextView(itemView: NavigationBarItemView): TextView {
        return itemView.findViewById(
            com.google.android.material.R.id.navigation_bar_item_large_label_view
        )
    }

    private fun setSubTextStyle(textView: TextView) {
        textView.typeface = ResourcesCompat.getFont(context, R.font.quicksand_bold)
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        textView.setTextColor(
            ContextCompat.getColor(
                context, com.example.sample01.R.color.button_purple
            )
        )
    }

    private fun buildTranslateIconAnimator(
        currentView: View,
        from: Float,
        to: Float =0f
    ): ObjectAnimator {
        return ObjectAnimator.ofFloat(
            currentView, "translationY", -from, to
        ).setDuration(300)
    }

    private fun buildTranslateCircleAnimator(
        oldCircle: View,
        from: Float
    ): ObjectAnimator {
        return ObjectAnimator.ofFloat(
            oldCircle, "translationY", 0f, from
        ).setDuration(300)
    }

    private fun buildTintAnimator(
        currentView: AppCompatImageView,
        enabled: Int,
        disabled: Int
    ): ValueAnimator {
        val animateTint = ValueAnimator.ofArgb(disabled, enabled)
        animateTint.duration = 10000
        animateTint.addUpdateListener {
            currentView.drawable.setTint(it.animatedValue as Int)
        }
        return animateTint
    }


    private fun setCircleSizeAndPosition(
        circleView: ImageView, paddingBottom: Int, //subtext size
        size: Int, //iconwidth*3
        x: Float, //itemView.x
        itemViewWidth: Int //itemView.width

    ) {
        val density = context.resources.displayMetrics.density
        val width = 60 * density
        val height = 60 * density
        circleView.layoutParams = RelativeLayout.LayoutParams(width.toInt(), height.toInt())
        val marginLeft = (itemViewWidth - width) / 2
        circleView.x = x + marginLeft

    }
}
