package kg.example.hm_06_03

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kg.example.hm_06_03.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private var binding: FragmentSecondBinding? = null

    fun onCreateView(
        inflater: LayoutInflater?, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflater?.let { FragmentSecondBinding.inflate(it, container, false) }
        val view: View = binding!!.getRoot()

        val layoutManager = LinearLayoutManager(requireContext())
        binding!!.rvSecond.setLayoutManager(layoutManager)

        val data: MutableList<String> = ArrayList()
        for (i in 1..20) {
            data.add("Item $i")
        }
        val adapter: RecyclerViewAdapter = RecyclerViewAdapter(data)
        binding!!.rvSecond.setAdapter(adapter)

        binding!!.btnSecond.setOnClickListener(View.OnClickListener {
            getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, ThirdFragment())
                .addToBackStack(null)
                .commit()
        })

        return view
    }

}