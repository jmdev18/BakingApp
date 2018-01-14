package com.udacity.willbrom.bakingapp.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.udacity.willbrom.bakingapp.R;
import com.udacity.willbrom.bakingapp.model.IngredientsModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class RecipeIngredientFragment extends Fragment {

    private List<IngredientsModel> ingredientsModelList;
    private OnIngredientItemClickListener clickListener;
    private Unbinder unbinder;
    @BindView(R.id.ingredient_title_textView) TextView ingredientTitle;

    public interface OnIngredientItemClickListener {
        void onIngredientItemClicked(List<IngredientsModel> ingredientsModelList);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            clickListener = (OnIngredientItemClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnIngredientItemClickListener");
        }
    }

    public RecipeIngredientFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_ingredient, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        Typeface customFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/satisfy-regular.ttf");
        ingredientTitle.setTypeface(customFont);
        return rootView;
    }

    @OnClick(R.id.card_ingredient)
    void onClick() {
        clickListener.onIngredientItemClicked(ingredientsModelList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setIngredientsModelList(List<IngredientsModel> ingredientsModelList) {
        this.ingredientsModelList = ingredientsModelList;
    }
}
