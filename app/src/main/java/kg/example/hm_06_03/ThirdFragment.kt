package kg.example.hm_06_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kg.example.hm_06_03.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {
    private var binding: FragmentThirdBinding? = null

    fun onCreateView(
        inflater: LayoutInflater?, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflater?.let { FragmentThirdBinding.inflate(it, container, false) }
        val view: View = binding!!.getRoot()

        val layoutManager = LinearLayoutManager(requireContext())
        binding!!.rvThird.setLayoutManager(layoutManager)

        val data: MutableList<String> = ArrayList()
        for (i in 1..20) {
            data.add("Item $i")
        }
        val adapter: RecyclerViewAdapter = RecyclerViewAdapter(data)
        binding!!.rvThird.setAdapter(adapter)

        binding!!.btnThird.setOnClickListener(View.OnClickListener { requireActivity().finish() })

        return view
    }


}