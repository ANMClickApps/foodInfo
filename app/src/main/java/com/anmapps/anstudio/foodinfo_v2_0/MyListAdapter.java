package com.anmapps.anstudio.foodinfo_v2_0;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MyListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Categoriya>categoriyasList;
    private ArrayList<Categoriya>originalList;
    ArrayList<Element> elementsList;


    public MyListAdapter(Context context, ArrayList<Categoriya> categoriyasList) {
        this.context = context;
        this.categoriyasList = new ArrayList<Categoriya>();
        this.categoriyasList.addAll(categoriyasList);
        this.originalList = new ArrayList<Categoriya>();
        this.originalList.addAll(categoriyasList);
    }

    public Object getChild(int groupPosition, int childPosition) {
        elementsList = categoriyasList.get(groupPosition).getElementsList();
        return elementsList.get(childPosition);
    }


    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View view, ViewGroup parent) {

        Element element = (Element) getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            /* LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
            view = layoutInflater.inflate(R.layout.element_row, null);
        }


        TextView name = (TextView) view.findViewById(R.id.textView1);
        ImageView img=(ImageView)view.findViewById(R.id.imageView1);

        name.setText(element.getName().trim());
        img.setImageResource(element.getElementImg());

        return view;
    }


    public int getChildrenCount(int groupPosition) {

        ArrayList<Element> countryList = categoriyasList.get(groupPosition).getElementsList();
        return countryList.size();

    }


    public Object getGroup(int groupPosition) {
        return categoriyasList.get(groupPosition);
    }


    public int getGroupCount() {
        return categoriyasList.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }


    public View getGroupView(int groupPosition, boolean isLastChild, View view,
                             ViewGroup parent) {

        Categoriya categoriya = (Categoriya) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.categ_row, null);
        }

        TextView heading = (TextView) view.findViewById(R.id.textView1);
        heading.setText(categoriya.getName().trim());
        ImageView headimg =(ImageView)view.findViewById(R.id.imageView1);
        headimg.setImageResource(categoriya.getCategImg());


        return view;
    }


    public boolean hasStableIds() {
        return true;
    }


    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filterData(String query){

        query = query.toLowerCase();
        Log.v("MyListAdapter", String.valueOf(categoriyasList.size()));
        categoriyasList.clear();

        if(query.isEmpty()){
            categoriyasList.addAll(originalList);
        }
        else {

            for(Categoriya categoriya: originalList){

                ArrayList<Element> elementList = categoriya.getElementsList();
                ArrayList<Element> newList = new ArrayList<Element>();
                for(Element element: elementList){
                    if(element.getName().toLowerCase().contains(query)){
                        newList.add(element);
                    }
                }
                if(newList.size() > 0){
                    Categoriya nCategoriya = new Categoriya(categoriya.getName(),categoriya.getCategImg(),newList);
                    categoriyasList.add(nCategoriya);
                }
            }
        }

        Log.v("MyListAdapter", String.valueOf(categoriyasList.size()));
        notifyDataSetChanged();

    }


}
