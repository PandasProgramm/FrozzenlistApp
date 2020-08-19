package de.miguel.frozzenlist.frozzenlistapp;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * =================================================================================================
 * @author Miguel Gutierrez, FrozzenList Project
 * Creates RecyclerViewAdapter for drag and drop list to show datalsit
 * Creates Usermanager for sending Userdata to RecyclerViewAdapter for setting Touchcallback and
 * sweapsiteattitude. Adapter for putting Object into List
 * @param: positition: position from userlist to getUser in userList and to get position from Freezer
 * @param: freezer_row: cellrecyling for performance
 * @param: Adapter<ViewHolder> which viewHolder for use Adapter</ViewHolder>=>RecylerViewHolder
 * =================================================================================================
 *
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    int position;
    UserManager userManager;

    public RecyclerViewAdapter(int position, UserManager userManager){
        this.position=position;
        this.userManager= userManager;
    }


    // For one cell from parent context:call by create cell(new ViewHolder)==>return viewHolder from freezerRow:
    //viewholder need the object from row with LayoutInflater  #matchparent: height like parent class

    /**
     *
     * @param parent: ViewGroup
     * @param viewType: add inflate to freezer_row
     * @return reezer_row Layout: false==> because android should perform the action automatically
     */

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.freezer_row,
                parent,false));
    }

    /**
     *
     * @param holder transfer attributs to View
     * @param position attributs by freezer: need userManager for userinformation and freezerlist:
     *                 call by position
     */


    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        holder.textView.setText(userManager.userList.get(position).freezers.get(position).getName()+
                     " hat "+ userManager.userList.get(position).freezers.get(position).tray+ " Fächer");

    }

    /**
     *  how many items to use
     * @return freezer size
     */

    @Override
    public int getItemCount() {
        Log.d("onButtonClick",String.valueOf(userManager.userList.get(position).freezers.size()));
        return userManager.userList.get(position).freezers.size();
    }

    /**
     *  Viewholder as Memberclass
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textLayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   Intent intent = new Intent(view.getContext(),TrayManager.class);
                   userManager.getUserList().get(position).freezers.get(getAdapterPosition());
                   view.getContext().startActivity(intent);
                }
            });

        }
    }
}
