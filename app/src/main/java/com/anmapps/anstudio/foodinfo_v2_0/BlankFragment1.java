package com.anmapps.anstudio.foodinfo_v2_0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import android.widget.SearchView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private ExpandableListView myList;
    private MyListAdapter listAdapter;
    private ArrayList<Categoriya> categoriyasList = new ArrayList<Categoriya>();
    private SearchView search;
    private static final String TAG = "myLogs";
    private View rootView;

    public BlankFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        displayList();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



    private void displayList() {
        Log.d(TAG, "загрузка DisplayList");
        //display the list
        loadSomeData();
        Log.d(TAG, "Загружено (loadSomeData) данные ");
        //get reference to the ExpandableListView
        myList = (ExpandableListView) rootView.findViewById(R.id.expandableListView1);
        //create the adapter by passing your ArrayList data
        listAdapter = new MyListAdapter(requireActivity(), categoriyasList);
        //attach the adapter to the list
        myList.setAdapter(listAdapter);

        myList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Element elementInfo= (Element)parent.getExpandableListAdapter().getChild(groupPosition,
                        childPosition);
                Intent intent=new Intent(requireActivity(), DetailActivity.class);
                intent.putExtra("Title", elementInfo.getName());
                intent.putExtra("Image_url",elementInfo.getElementImg());
                intent.putExtra("Details", elementInfo.getElementDetails());
                startActivity(intent);

                Toast.makeText(requireActivity(), elementInfo.getName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        myList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                return false;
            }
        });
    }

    public void loadSomeData() {

        ArrayList<Element> elementsList = new ArrayList<Element>();


        Element element = new Element("Абрикос", R.drawable.apricot, getString(R.string.apricot));
        elementsList.add(element);
        element = new Element("Авокадо", R.drawable.avocado, getString(R.string.avocado));
        elementsList.add(element);
        element = new Element("Алыча", R.drawable.cherry_plum, getString(R.string.cherry_plum));
        elementsList.add(element);
        element = new Element("Ананас", R.drawable.ananas,getString(R.string.pineapple));
        elementsList.add(element);
        element = new Element("Аннона", R.drawable.sugar_apple,getString(R.string.sugar_apple));
        elementsList.add(element);
        element = new Element("Апельсин", R.drawable.orange,getString(R.string.orange));
        elementsList.add(element);
        element = new Element("Банан", R.drawable.banana,getString(R.string.banana));
        elementsList.add(element);
        element = new Element("Бергамот", R.drawable.bergamot,getString(R.string.bergamot));
        elementsList.add(element);
        element = new Element("Гранат", R.drawable.pomegranate,getString(R.string.pomegranate));
        elementsList.add(element);
        element = new Element("Грейфрут", R.drawable.grapefruit,getString(R.string.grapefruit));
        elementsList.add(element);
        element = new Element("Груша", R.drawable.pear,getString(R.string.pear));
        elementsList.add(element);
        element = new Element("Гуава", R.drawable.guava,getString(R.string.guava));
        elementsList.add(element);
        element = new Element("Джекфрут", R.drawable.jackfruit,getString(R.string.jackfruit));
        elementsList.add(element);
        element = new Element("Драконовый фрукт", R.drawable.pitahaya,getString(R.string.pitahaya));
        elementsList.add(element);
        element = new Element("Дуриан", R.drawable.durian,getString(R.string.durian));
        elementsList.add(element);
        element = new Element("Карамбола", R.drawable.carambola,getString(R.string.carambola));
        elementsList.add(element);
        element = new Element("Киви", R.drawable.kiwi,getString(R.string.kiwi));
        elementsList.add(element);
        element = new Element("Клементины", R.drawable.clementines,getString(R.string.clementines));
        elementsList.add(element);
        element = new Element("Кумкват", R.drawable.cumquat,getString(R.string.cumquat));
        elementsList.add(element);
        element = new Element("Лайм", R.drawable.lime,getString(R.string.lime));
        elementsList.add(element);
        element = new Element("Лимон", R.drawable.lemon,getString(R.string.lemon));
        elementsList.add(element);
        element = new Element("Личи", R.drawable.lichee,getString(R.string.lichee));
        elementsList.add(element);
        element = new Element("Лонган (Лам Яй)", R.drawable.longan,getString(R.string.longan));
        elementsList.add(element);
        element = new Element("Манго", R.drawable.mango,getString(R.string.mango));
        elementsList.add(element);
        element = new Element("Мангостин", R.drawable.mangosteen,getString(R.string.mangosteen));
        elementsList.add(element);
        element = new Element("Мандарин", R.drawable.mandarin,getString(R.string.mandarin));
        elementsList.add(element);
        element = new Element("Маракуя", R.drawable.passionfruit,getString(R.string.passionfruit));
        elementsList.add(element);
        element = new Element("Мушмула", R.drawable.medlar,getString(R.string.medlar));
        elementsList.add(element);
        element = new Element("Нектарин", R.drawable.nectarine,getString(R.string.nectarine));
        elementsList.add(element);
        element = new Element("Папаяй", R.drawable.papaya,getString(R.string.papaya));
        elementsList.add(element);
        element = new Element("Персик", R.drawable.peach,getString(R.string.peach));
        elementsList.add(element);
        element = new Element("Помело", R.drawable.pomelo,getString(R.string.pomelo));
        elementsList.add(element);
        element = new Element("Померанец", R.drawable.pomeranian,getString(R.string.pomeranian));
        elementsList.add(element);
        element = new Element("Рамбутан", R.drawable.rambutan,getString(R.string.rambutan));
        elementsList.add(element);
        element = new Element("Салак", R.drawable.salak,getString(R.string.salak));
        elementsList.add(element);
        element = new Element("Саподилла", R.drawable.sapodilla,getString(R.string.sapodilla));
        elementsList.add(element);
        element = new Element("Свити", R.drawable.sweetie,getString(R.string.sweetie));
        elementsList.add(element);
        element = new Element("Слива", R.drawable.plum,getString(R.string.plum));
        elementsList.add(element);
        element = new Element("Танжело", R.drawable.tangelos,getString(R.string.tangelos));
        elementsList.add(element);
        element = new Element("Хеномелес", R.drawable.chaenomeles,getString(R.string.chaenomeles));
        elementsList.add(element);
        element = new Element("Хурма", R.drawable.persimmon,getString(R.string.persimmon));
        elementsList.add(element);
        element = new Element("Цитрон", R.drawable.citron,getString(R.string.citron));
        elementsList.add(element);
        element = new Element("Черимойя", R.drawable.cherimoya,getString(R.string.cherimoya));
        elementsList.add(element);
        element = new Element("Чомпу (розовое яблоко)", R.drawable.chomphu,getString(R.string.chomphu));
        elementsList.add(element);
        element = new Element("Яблоко", R.drawable.apple,getString(R.string.apple));
        elementsList.add(element);

        Categoriya categoriya = new Categoriya("Фрукты",R.drawable.fruit_v,elementsList);
        categoriyasList.add(categoriya);


        elementsList=new ArrayList<Element>();
        element = new Element("Аррорут", R.drawable.arrowroot, getString(R.string.arrowroot));
        elementsList.add(element);
        element = new Element("Баклажан", R.drawable.aubergine,getString(R.string.aubergine));
        elementsList.add(element);
        element = new Element("Бамия", R.drawable.okra, getString(R.string.okra));
        elementsList.add(element);
        element = new Element("Батат", R.drawable.batata, getString(R.string.batata));
        elementsList.add(element);
        element = new Element("Брюква", R.drawable.swede, getString(R.string.swede));
        elementsList.add(element);
        element = new Element("Буряк", R.drawable.buriak, getString(R.string.buriak));
        elementsList.add(element);
        element = new Element("Дайкон (японська редька)", R.drawable.daikon, getString(R.string.daikon));
        elementsList.add(element);
        element = new Element("Кабачок", R.drawable.marrow, getString(R.string.marrow));
        elementsList.add(element);
        element = new Element("Каперсы", R.drawable.caper, getString(R.string.caper));
        elementsList.add(element);
        element = new Element("Капуста белокачанная", R.drawable.cabbage, getString(R.string.cabbage));
        elementsList.add(element);
        element = new Element("Капуста брокколи", R.drawable.broccoli, getString(R.string.broccoli));
        elementsList.add(element);
        element = new Element("Капуста брюссельская", R.drawable.brussels_sprouts, getString(R.string.brussels_sprouts));
        elementsList.add(element);
        element = new Element("Капуста кольраби", R.drawable.kohlrabi, getString(R.string.kohlrabi));
        elementsList.add(element);
        element = new Element("Капуста краснокочанная", R.drawable.cabbage_scotch, getString(R.string.cabbage_scotch));
        elementsList.add(element);
        element = new Element("Капуста пак-чой", R.drawable.pak_choi, getString(R.string.pak_choi));
        elementsList.add(element);
        element = new Element("Капуста пекинская", R.drawable.chinese_cabbage, getString(R.string.chinese_cabbage));
        elementsList.add(element);
        element = new Element("Капуста романеско", R.drawable.romanesco_cabbage, getString(R.string.romanesco_cabbage));
        elementsList.add(element);
        element = new Element("Капуста савойская", R.drawable.savoy_cabbage, getString(R.string.savoy_cabbage));
        elementsList.add(element);
        element = new Element("Капуста цветная", R.drawable.cauliflower, getString(R.string.cauliflower));
        elementsList.add(element);
        element = new Element("Картофель", R.drawable.potato, getString(R.string.potato));
        elementsList.add(element);
        element = new Element("Кукуруза", R.drawable.maize, getString(R.string.maize));
        elementsList.add(element);
        element = new Element("Лук репчастый", R.drawable.onion, getString(R.string.onion));
        elementsList.add(element);
        element = new Element("Лук-порей", R.drawable.leek, getString(R.string.leek));
        elementsList.add(element);
        element = new Element("Лук-шалот", R.drawable.scallion, getString(R.string.scallion));
        elementsList.add(element);
        element = new Element("Люффа", R.drawable.loofah, getString(R.string.loofah));
        elementsList.add(element);
        element = new Element("Момордика", R.drawable.momordica, getString(R.string.momordica));
        elementsList.add(element);
        element = new Element("Морковь", R.drawable.carrot, getString(R.string.carrot));
        elementsList.add(element);
        element = new Element("Огурец", R.drawable.cucumber, getString(R.string.cucumber));
        elementsList.add(element);
        element = new Element("Пастернак", R.drawable.parsnip, getString(R.string.parsnip));
        elementsList.add(element);
        element = new Element("Патиссон", R.drawable.pattypan_squash, getString(R.string.pattypan_squash));
        elementsList.add(element);
        element = new Element("Перец сладкий", R.drawable.sweet_pepper, getString(R.string.sweet_pepper));
        elementsList.add(element);
        element = new Element("Помидор", R.drawable.tomato, getString(R.string.tomato));
        elementsList.add(element);
        element = new Element("Помидоры черри", R.drawable.cherry_tomatoes, getString(R.string.cherry_tomatoes));
        elementsList.add(element);
        element = new Element("Радиккио", R.drawable.radicchio, getString(R.string.radicchio));
        elementsList.add(element);
        element = new Element("Редис", R.drawable.garden_radish, getString(R.string.garden_radish));
        elementsList.add(element);
        element = new Element("Редька", R.drawable.summer_radish, getString(R.string.summer_radish));
        elementsList.add(element);
        element = new Element("Редька черная", R.drawable.black_radish, getString(R.string.black_radish));
        elementsList.add(element);
        element = new Element("Репа", R.drawable.turnip, getString(R.string.turnip));
        elementsList.add(element);
        element = new Element("Свекла", R.drawable.beet, getString(R.string.beet));
        elementsList.add(element);
        element = new Element("Топинамбур", R.drawable.jerusalem_artichoke, getString(R.string.jerusalem_artichoke));
        elementsList.add(element);
        element = new Element("Турецкий горох (нут)", R.drawable.turkish_peas, getString(R.string.turkish_peas));
        elementsList.add(element);
        element = new Element("Тыква", R.drawable.pumpkin, getString(R.string.pumpkin));
        elementsList.add(element);
        element = new Element("Фенхель", R.drawable.fennel, getString(R.string.fennel));
        elementsList.add(element);
        element = new Element("Хрен", R.drawable.horseradish, getString(R.string.horseradish));
        elementsList.add(element);
        element = new Element("Цуккини", R.drawable.zucchini, getString(R.string.zucchini));
        elementsList.add(element);
        element = new Element("Чайот", R.drawable.chayotes, getString(R.string.chayotes));
        elementsList.add(element);
        element = new Element("Чеснок", R.drawable.garlic, getString(R.string.garlic));
        elementsList.add(element);
        element = new Element("Ямс", R.drawable.yam, getString(R.string.yam));
        elementsList.add(element);

        categoriya = new Categoriya("Овощи",R.drawable.veget,elementsList);
        categoriyasList.add(categoriya);


        elementsList=new ArrayList<Element>();
        element = new Element("Арбуз", R.drawable.watermelon, getString(R.string.watermelon));
        elementsList.add(element);
        element = new Element("Барбарис", R.drawable.barberry, getString(R.string.barberry));
        elementsList.add(element);
        element = new Element("Брусника", R.drawable.cowberry, getString(R.string.cowberry));
        elementsList.add(element);
        element = new Element("Бузина", R.drawable.elder, getString(R.string.elder));
        elementsList.add(element);
        element = new Element("Виноград", R.drawable.vine, getString(R.string.vine));
        elementsList.add(element);
        element = new Element("Вишня", R.drawable.cherry, getString(R.string.cherry));
        elementsList.add(element);
        element = new Element("Годжи", R.drawable.goji_berry, getString(R.string.goji_berry));
        elementsList.add(element);
        element = new Element("Голубика", R.drawable.blueberry, getString(R.string.blueberry));
        elementsList.add(element);
        element = new Element("Дыня", R.drawable.melon, getString(R.string.melon));
        elementsList.add(element);
        element = new Element("Ежевика", R.drawable.blackberry, getString(R.string.blackberry));
        elementsList.add(element);
        element = new Element("Земляника", R.drawable.strawberries, getString(R.string.strawberries));
        elementsList.add(element);
        element = new Element("Ирга", R.drawable.serviceberry, getString(R.string.serviceberry));
        elementsList.add(element);
        element = new Element("Калина", R.drawable.guelder_rose, getString(R.string.guelder_rose));
        elementsList.add(element);
        element = new Element("Кизил", R.drawable.cornel, getString(R.string.cornel));
        elementsList.add(element);
        element = new Element("Клубника", R.drawable.strawberry, getString(R.string.strawberry));
        elementsList.add(element);
        element = new Element("Клюква", R.drawable.cranberry, getString(R.string.cranberry));
        elementsList.add(element);
        element = new Element("Красная смородина", R.drawable.redcurrant, getString(R.string.redcurrant));
        elementsList.add(element);
        element = new Element("Крыжовник", R.drawable.gooseberry, getString(R.string.gooseberry));
        elementsList.add(element);
        element = new Element("Лимонник", R.drawable.schisandra, getString(R.string.schisandra));
        elementsList.add(element);
        element = new Element("Малина", R.drawable.raspberry, getString(R.string.raspberry));
        elementsList.add(element);
        element = new Element("Морошка", R.drawable.cloudberry, getString(R.string.cloudberry));
        elementsList.add(element);
        element = new Element("Облепиха", R.drawable.sea_buckthorn, getString(R.string.sea_buckthorn));
        elementsList.add(element);
        element = new Element("Оливки", R.drawable.olive, getString(R.string.olive));
        elementsList.add(element);
        element = new Element("Рябина", R.drawable.rowan, getString(R.string.rowan));
        elementsList.add(element);
        element = new Element("Терн", R.drawable.blackthorn, getString(R.string.blackthorn));
        elementsList.add(element);
        element = new Element("Фейхоа", R.drawable.feijoa, getString(R.string.feijoa));
        elementsList.add(element);
        element = new Element("Физалис", R.drawable.physalis, getString(R.string.physalis));
        elementsList.add(element);
        element = new Element("Черемуха", R.drawable.bird_cherry, getString(R.string.bird_cherry));
        elementsList.add(element);
        element = new Element("Черешня", R.drawable.cherries, getString(R.string.cherries));
        elementsList.add(element);
        element = new Element("Черная смородина", R.drawable.blackcurrant, getString(R.string.blackcurrant));
        elementsList.add(element);
        element = new Element("Черника", R.drawable.bilberry, getString(R.string.bilberry));
        elementsList.add(element);
        element = new Element("Черноплодная рябина (Арония)", R.drawable.chokeberry, getString(R.string.chokeberry));
        elementsList.add(element);
        element = new Element("Шелковица", R.drawable.mulberry, getString(R.string.mulberry));
        elementsList.add(element);
        element = new Element("Шиповник", R.drawable.brier, getString(R.string.brier));
        elementsList.add(element);

        categoriya = new Categoriya("Ягоды",R.drawable.ffood,elementsList);
        categoriyasList.add(categoriya);

        elementsList=new ArrayList<Element>();
        element = new Element("Арахис", R.drawable.peanut, getString(R.string.peanut));
        elementsList.add(element);
        element = new Element("Бразильский орех", R.drawable.brazil_nuts, getString(R.string.brazil_nuts));
        elementsList.add(element);
        element = new Element("Водяной орех", R.drawable.chilim, getString(R.string.chilim));
        elementsList.add(element);
        element = new Element("Грецкий орех", R.drawable.walnut, getString(R.string.walnut));
        elementsList.add(element);
        element = new Element("Каштан", R.drawable.chestnut, getString(R.string.chestnut));
        elementsList.add(element);
        element = new Element("Кедровые орехи", R.drawable.pine_nut, getString(R.string.pine_nut));
        elementsList.add(element);
        element = new Element("Кешью", R.drawable.cashew, getString(R.string.cashew));
        elementsList.add(element);
        element = new Element("Кокос", R.drawable.coconut, getString(R.string.coconut));
        elementsList.add(element);
        element = new Element("Кола", R.drawable.cola_nuts, getString(R.string.cola_nuts));
        elementsList.add(element);
        element = new Element("Макадамия", R.drawable.macadamia, getString(R.string.macadamia));
        elementsList.add(element);
        element = new Element("Миндаль", R.drawable.almond, getString(R.string.almond));
        elementsList.add(element);
        element = new Element("Мускатный орех", R.drawable.nutmeg, getString(R.string.nutmeg));
        elementsList.add(element);
        element = new Element("Пекан", R.drawable.pecan, getString(R.string.pecan));
        elementsList.add(element);
        element = new Element("Пинии", R.drawable.pine_nuts, getString(R.string.pine_nuts));
        elementsList.add(element);
        element = new Element("Фисташки", R.drawable.pistachios, getString(R.string.pistachios));
        elementsList.add(element);
        element = new Element("Фундук", R.drawable.filbert, getString(R.string.filbert));
        elementsList.add(element);

        categoriya = new Categoriya("Орехи",R.drawable.oreh,elementsList);
        categoriyasList.add(categoriya);

        elementsList=new ArrayList<Element>();
        element = new Element("Изюм", R.drawable.raisins, getString(R.string.raisins));
        elementsList.add(element);
        element = new Element("Инжир", R.drawable.fig, getString(R.string.fig));
        elementsList.add(element);
        element = new Element("Курага (урюк)", R.drawable.dried_apricots, getString(R.string.dried_apricots));
        elementsList.add(element);
        element = new Element("Финик", R.drawable.date, getString(R.string.date));
        elementsList.add(element);
        element = new Element("Чернослив", R.drawable.french_plum, getString(R.string.french_plum));
        elementsList.add(element);

        categoriya = new Categoriya("Сухофрукты",R.drawable.syhofr,elementsList);
        categoriyasList.add(categoriya);

        elementsList=new ArrayList<Element>();
        element = new Element("Белый гриб", R.drawable.cep, getString(R.string.cep));
        elementsList.add(element);
        element = new Element("Вешенки", R.drawable.oyster_mushrooms, getString(R.string.oyster_mushrooms));
        elementsList.add(element);
        element = new Element("Грузки", R.drawable.milk_mushroom, getString(R.string.milk_mushroom));
        elementsList.add(element);
        element = new Element("Ивишень (подвишенник)", R.drawable.ivishen, getString(R.string.ivishen));
        elementsList.add(element);
        element = new Element("Лисички", R.drawable.chanterelles, getString(R.string.chanterelles));
        elementsList.add(element);
        element = new Element("Маслята", R.drawable.luteus, getString(R.string.luteus));
        elementsList.add(element);
        element = new Element("Моховик", R.drawable.boletus, getString(R.string.boletus));
        elementsList.add(element);
        element = new Element("Муэр", R.drawable.muer, getString(R.string.muer));
        elementsList.add(element);
        element = new Element("Опята", R.drawable.nameko, getString(R.string.nameko));
        elementsList.add(element);
        element = new Element("Подберезовик", R.drawable.brown_cap_boletus, getString(R.string.brown_cap_boletus));
        elementsList.add(element);
        element = new Element("Подосиновик", R.drawable.orange_cap_boletus, getString(R.string.orange_cap_boletus));
        elementsList.add(element);
        element = new Element("Портобелло", R.drawable.portobello, getString(R.string.portobello));
        elementsList.add(element);
        element = new Element("Рыжик", R.drawable.saffron_milk_cap, getString(R.string.saffron_milk_cap));
        elementsList.add(element);
        element = new Element("Рядовки", R.drawable.blewits, getString(R.string.blewits));
        elementsList.add(element);
        element = new Element("Сморчки", R.drawable.morels, getString(R.string.morels));
        elementsList.add(element);
        element = new Element("Сыроежки", R.drawable.russula, getString(R.string.russula));
        elementsList.add(element);
        element = new Element("Трюфель", R.drawable.truffle, getString(R.string.truffle));
        elementsList.add(element);
        element = new Element("Шампиньон", R.drawable.champignon, getString(R.string.champignon));
        elementsList.add(element);
        element = new Element("Шиитак", R.drawable.shiitake, getString(R.string.shiitake));
        elementsList.add(element);
        element = new Element("Шимеджи", R.drawable.shimedzhi, getString(R.string.shimedzhi));
        elementsList.add(element);
        element = new Element("Эноки", R.drawable.enoki, getString(R.string.enoki));
        elementsList.add(element);

        categoriya = new Categoriya("Грибы",R.drawable.grib,elementsList);
        categoriyasList.add(categoriya);

        elementsList=new ArrayList<Element>();
        element = new Element("Баранина", R.drawable.mutton, getString(R.string.mutton));
        elementsList.add(element);
        element = new Element("Бекон", R.drawable.bacon, getString(R.string.bacon));
        elementsList.add(element);
        element = new Element("Буженина", R.drawable.cold_baked_pork, getString(R.string.cold_baked_pork));
        elementsList.add(element);
        element = new Element("Верблюжатина", R.drawable.camel, getString(R.string.camel));
        elementsList.add(element);
        element = new Element("Ветчина", R.drawable.ham, getString(R.string.ham));
        elementsList.add(element);
        element = new Element("Говядина", R.drawable.beef, getString(R.string.beef));
        elementsList.add(element);
        element = new Element("Зайчатина", R.drawable.hare, getString(R.string.hare));
        elementsList.add(element);
        element = new Element("Китовое мясо", R.drawable.whale_meat, getString(R.string.whale_meat));
        elementsList.add(element);
        element = new Element("Козье мясо", R.drawable.goat_meat, getString(R.string.goat_meat));
        elementsList.add(element);
        element = new Element("Конина", R.drawable.horseflesh, getString(R.string.horseflesh));
        elementsList.add(element);
        element = new Element("Крокодилье мясо", R.drawable.crocodile_meat, getString(R.string.crocodile_meat));
        elementsList.add(element);
        element = new Element("Кролик", R.drawable.rabbit, getString(R.string.rabbit));
        elementsList.add(element);
        element = new Element("Оленина", R.drawable.venison, getString(R.string.venison));
        elementsList.add(element);
        element = new Element("Печень", R.drawable.liver, getString(R.string.liver));
        elementsList.add(element);
        element = new Element("Сало", R.drawable.fat, getString(R.string.fat));
        elementsList.add(element);
        element = new Element("Свинина", R.drawable.pork, getString(R.string.pork));
        elementsList.add(element);
        element = new Element("Телятина", R.drawable.veal, getString(R.string.veal));
        elementsList.add(element);
        element = new Element("Язык", R.drawable.tongue, getString(R.string.tongue));
        elementsList.add(element);

        categoriya = new Categoriya("Мясо",R.drawable.meat_v,elementsList);
        categoriyasList.add(categoriya);

        elementsList=new ArrayList<Element>();
        element = new Element("Глухарь", R.drawable.capercaillie, getString(R.string.capercaillie));
        elementsList.add(element);
        element = new Element("Голубь", R.drawable.pigeon, getString(R.string.pigeon));
        elementsList.add(element);
        element = new Element("Гусь", R.drawable.goose, getString(R.string.goose));
        elementsList.add(element);
        element = new Element("Индейка", R.drawable.turkey, getString(R.string.turkey));
        elementsList.add(element);
        element = new Element("Курица", R.drawable.chicken, getString(R.string.chicken));
        elementsList.add(element);
        element = new Element("Куропатка", R.drawable.partridge, getString(R.string.partridge));
        elementsList.add(element);
        element = new Element("Перепелка", R.drawable.quail, getString(R.string.quail));
        elementsList.add(element);
        element = new Element("Рябчик", R.drawable.grouse, getString(R.string.grouse));
        elementsList.add(element);
        element = new Element("Страус", R.drawable.ostrich, getString(R.string.ostrich));
        elementsList.add(element);
        element = new Element("Тетерев", R.drawable.black_grouse, getString(R.string.black_grouse));
        elementsList.add(element);
        element = new Element("Утка", R.drawable.duck, getString(R.string.duck));
        elementsList.add(element);
        element = new Element("Цесарка", R.drawable.guinea_fowl, getString(R.string.guinea_fowl));
        elementsList.add(element);
        element = new Element("Цыплята", R.drawable.chickens, getString(R.string.chickens));
        elementsList.add(element);


        categoriya = new Categoriya("Птица",R.drawable.ptica_v,elementsList);
        categoriyasList.add(categoriya);

        elementsList=new ArrayList<Element>();
        element = new Element("Голубиные", R.drawable.pigeon_eggs, getString(R.string.pigeon_eggs));
        elementsList.add(element);
        element = new Element("Гусиные", R.drawable.goose_eggs, getString(R.string.goose_eggs));
        elementsList.add(element);
        element = new Element("Индюшиные", R.drawable.turkey_eggs, getString(R.string.turkey_eggs));
        elementsList.add(element);
        element = new Element("Куриные", R.drawable.egg, getString(R.string.egg));
        elementsList.add(element);
        element = new Element("Перепелиные", R.drawable.quail_egg, getString(R.string.quail_egg));
        elementsList.add(element);
        element = new Element("Страусиные", R.drawable.ostrich_egg, getString(R.string.ostrich_egg));
        elementsList.add(element);
        element = new Element("Утиные", R.drawable.duck_eggs, getString(R.string.duck_eggs));
        elementsList.add(element);
        element = new Element("Фазаньи", R.drawable.pheasant_eggs, getString(R.string.pheasant_eggs));
        elementsList.add(element);
        element = new Element("Цесарок", R.drawable.guinea_fowl_eggs, getString(R.string.guinea_fowl_eggs));
        elementsList.add(element);
        element = new Element("Черепашьи", R.drawable.turtle_eggs, getString(R.string.turtle_eggs));
        elementsList.add(element);
        element = new Element("Страуса эму", R.drawable.emu_eggs, getString(R.string.emu_eggs));
        elementsList.add(element);

        categoriya = new Categoriya("Яйца",R.drawable.yaico,elementsList);
        categoriyasList.add(categoriya);

        elementsList=new ArrayList<Element>();
        element = new Element("Брынза", R.drawable.brynza, getString(R.string.brynza));
        elementsList.add(element);
        element = new Element("Камамбер и бри", R.drawable.camembert, getString(R.string.camembert));
        elementsList.add(element);
        element = new Element("Масло сливочное", R.drawable.butter, getString(R.string.butter));
        elementsList.add(element);
        element = new Element("Сливки", R.drawable.cream, getString(R.string.cream));
        elementsList.add(element);
        element = new Element("Сметана", R.drawable.sour_cream, getString(R.string.sour_cream));
        elementsList.add(element);
        element = new Element("Творог", R.drawable.curd, getString(R.string.curd));
        elementsList.add(element);
        element = new Element("Тофу", R.drawable.tofu, getString(R.string.tofu));
        elementsList.add(element);

        categoriya = new Categoriya("Молочные",R.drawable.milk_kat,elementsList);
        categoriyasList.add(categoriya);

        elementsList=new ArrayList<Element>();
        element = new Element("Абсент", R.drawable.absinthe, getString(R.string.absinthe));
        elementsList.add(element);
        element = new Element("Аквавит", R.drawable.aquavit, getString(R.string.aquavit));
        elementsList.add(element);
        element = new Element("Анисовая настойка", R.drawable.anisette, getString(R.string.anisette));
        elementsList.add(element);
        element = new Element("Арак", R.drawable.arrack, getString(R.string.arrack));
        elementsList.add(element);
        element = new Element("Арманьяк", R.drawable.armagnac, getString(R.string.armagnac));
        elementsList.add(element);
        element = new Element("Бальзам", R.drawable.balm, getString(R.string.balm));
        elementsList.add(element);
        element = new Element("Бенедиктин", R.drawable.benedictine, getString(R.string.benedictine));
        elementsList.add(element);
        element = new Element("Бренди", R.drawable.brandy, getString(R.string.brandy));
        elementsList.add(element);
        element = new Element("Бурбон", R.drawable.bourbon, getString(R.string.bourbon));
        elementsList.add(element);
        element = new Element("Вермут", R.drawable.vermouth, getString(R.string.vermouth));
        elementsList.add(element);
        element = new Element("Вино", R.drawable.wine, getString(R.string.wine));
        elementsList.add(element);
        element = new Element("Виски", R.drawable.whiskey, getString(R.string.whiskey));
        elementsList.add(element);
        element = new Element("Вишневый ликер", R.drawable.cherry_brandy, getString(R.string.cherry_brandy));
        elementsList.add(element);
        element = new Element("Вода негазированная", R.drawable.water_is_still, getString(R.string.water_is_still));
        elementsList.add(element);
        element = new Element("Вода газированная", R.drawable.carbonated_water, getString(R.string.carbonated_water));
        elementsList.add(element);
        element = new Element("Водка", R.drawable.vodka, getString(R.string.vodka));
        elementsList.add(element);
        element = new Element("Глинтвейн", R.drawable.mulled_wine, getString(R.string.mulled_wine));
        elementsList.add(element);
        element = new Element("Гоголь-моголь", R.drawable.eggnog, getString(R.string.eggnog));
        elementsList.add(element);
        element = new Element("Граппа", R.drawable.grappa, getString(R.string.grappa));
        elementsList.add(element);
        element = new Element("Грог", R.drawable.grog, getString(R.string.grog));
        elementsList.add(element);
        element = new Element("Джин", R.drawable.gin, getString(R.string.gin));
        elementsList.add(element);
        element = new Element("Джулеп", R.drawable.julep, getString(R.string.julep));
        elementsList.add(element);
        element = new Element("Какао", R.drawable.cocoa, getString(R.string.cocoa));
        elementsList.add(element);
        element = new Element("Кальвадос", R.drawable.calvados, getString(R.string.calvados));
        elementsList.add(element);
        element = new Element("Кашаса", R.drawable.cachaca, getString(R.string.cachaca));
        elementsList.add(element);
        element = new Element("Квас", R.drawable.kvass, getString(R.string.kvass));
        elementsList.add(element);
        element = new Element("Кефир", R.drawable.kefir, getString(R.string.kefir));
        elementsList.add(element);
        element = new Element("Кисель", R.drawable.fool, getString(R.string.fool));
        elementsList.add(element);
        element = new Element("Коблер", R.drawable.cobbler, getString(R.string.cobbler));
        elementsList.add(element);
        element = new Element("Коктейль", R.drawable.cocktail, getString(R.string.cocktail));
        elementsList.add(element);
        element = new Element("Кола", R.drawable.cola, getString(R.string.cola));
        elementsList.add(element);
        element = new Element("Компот", R.drawable.compote, getString(R.string.compote));
        elementsList.add(element);
        element = new Element("Коньяк", R.drawable.cognac, getString(R.string.cognac));
        elementsList.add(element);
        element = new Element("Кофе", R.drawable.coffee, getString(R.string.coffee));
        elementsList.add(element);
        element = new Element("Крюшон", R.drawable.cup, getString(R.string.cup));
        elementsList.add(element);
        element = new Element("Кумыс", R.drawable.koumiss, getString(R.string.koumiss));
        elementsList.add(element);
        element = new Element("Ликер", R.drawable.liquor, getString(R.string.liquor));
        elementsList.add(element);
        element = new Element("Лимонад", R.drawable.lemonade, getString(R.string.lemonade));
        elementsList.add(element);
        element = new Element("Мартини", R.drawable.martini, getString(R.string.martini));
        elementsList.add(element);
        element = new Element("Медовуха", R.drawable.mead, getString(R.string.mead));
        elementsList.add(element);
        element = new Element("Молоко", R.drawable.milk, getString(R.string.milk));
        elementsList.add(element);
        element = new Element("Морс", R.drawable.morse, getString(R.string.morse));
        elementsList.add(element);
        element = new Element("Пиво", R.drawable.beer, getString(R.string.beer));
        elementsList.add(element);
        element = new Element("Писко", R.drawable.pisco, getString(R.string.pisco));
        elementsList.add(element);
        element = new Element("Пунш", R.drawable.punch, getString(R.string.punch));
        elementsList.add(element);
        element = new Element("Ром", R.drawable.rum, getString(R.string.rum));
        elementsList.add(element);
        element = new Element("Сакэ", R.drawable.sake, getString(R.string.sake));
        elementsList.add(element);
        element = new Element("Самогон", R.drawable.moonshine, getString(R.string.moonshine));
        elementsList.add(element);
        element = new Element("Сбитень", R.drawable.sbiten, getString(R.string.sbiten));
        elementsList.add(element);
        element = new Element("Сливовица", R.drawable.slivovitz, getString(R.string.slivovitz));
        elementsList.add(element);
        element = new Element("Сок", R.drawable.juice, getString(R.string.juice));
        elementsList.add(element);
        element = new Element("Спирт", R.drawable.alcohol, getString(R.string.alcohol));
        elementsList.add(element);
        element = new Element("Сыворотка", R.drawable.whey, getString(R.string.whey));
        elementsList.add(element);
        element = new Element("Текила", R.drawable.tequila, getString(R.string.tequila));
        elementsList.add(element);
        element = new Element("Узвар", R.drawable.uzvar, getString(R.string.uzvar));
        elementsList.add(element);
        element = new Element("Физ", R.drawable.nat, getString(R.string.nat));
        elementsList.add(element);
        element = new Element("Фраппе", R.drawable.frappe, getString(R.string.frappe));
        elementsList.add(element);
        element = new Element("Чай", R.drawable.tea, getString(R.string.tea));
        elementsList.add(element);
        element = new Element("Шампанское", R.drawable.champagne, getString(R.string.champagne));
        elementsList.add(element);
        element = new Element("Шартрез", R.drawable.chartreuse, getString(R.string.chartreuse));
        elementsList.add(element);
        element = new Element("Эг-ног", R.drawable.egg_nog, getString(R.string.egg_nog));
        elementsList.add(element);

        categoriya = new Categoriya("Напитки",R.drawable.napitki,elementsList);
        categoriyasList.add(categoriya);
    }
}
