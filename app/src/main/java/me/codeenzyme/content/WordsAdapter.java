package me.codeenzyme.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordsViewHolder> {
    private String[] mWords;
    private Context mContext;

    public WordsAdapter(String[] words, Context context) {
        this.mWords = words;
        this.mContext = context;
    }

    @NonNull
    @Override
    public WordsAdapter.WordsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new WordsViewHolder(inflater.inflate(R.layout.word_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WordsAdapter.WordsViewHolder holder, int position) {
        holder.getText().setText(mWords[position]);
    }

    @Override
    public int getItemCount() {
        return mWords.length;
    }

    public class WordsViewHolder extends RecyclerView.ViewHolder {
        private TextView text;
        public WordsViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.word_text);
        }

        public TextView getText() {
            return text;
        }
    }
}
