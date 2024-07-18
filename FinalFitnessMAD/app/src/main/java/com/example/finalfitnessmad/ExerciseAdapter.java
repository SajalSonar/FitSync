package com.example.finalfitnessmad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {

    public void deleteItem(int position) {
        exerciseList.remove(position);
        notifyItemRemoved(position);
    }

    private List<Exercise> exerciseList;
    public ExerciseAdapter(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item_exercise, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Exercise exercise = exerciseList.get(position);
        holder.bind(exercise);
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    static class ExerciseViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewExercise, setAndReps, partAndExe;
        ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewExercise = itemView.findViewById(R.id.textViewExercise);
            setAndReps = itemView.findViewById(R.id.setAndReps);
            partAndExe = itemView.findViewById(R.id.partAndExe);
        }

        void bind(Exercise exercise) {
//          textViewExercise.setText("Date : " + exercise.getDate());
            setAndReps.setText("Part : "+ exercise.getBodyPart()+ "  Exercise : "+ exercise.getExercise());
            partAndExe.setText("Sets : "+ exercise.getSets() + "  Reps : "+ exercise.getReps());
        }
    }
}

