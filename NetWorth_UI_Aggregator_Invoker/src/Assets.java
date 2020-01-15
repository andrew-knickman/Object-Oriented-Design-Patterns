import java.util.ArrayList;

public class Assets 
{
	private ArrayList<AssetItem> assets;
	public Assets()
	{
		assets = new ArrayList<AssetItem>();
		populate();
	}
	private void populate()
	{
		assets.add(new AssetItem("House", 300000.00));
		assets.add(new AssetItem("Savings", 600000.00));
		assets.add(new AssetItem("Car", 3000.00));
	}
	public void addItem(AssetItem a)
	{
		assets.add(a);
	}
	public double total()
	{
		Object[] assetlist = assets.toArray();
		double total = 0.0;
		for(int i = 0; i < assetlist.length; i++)
		{
			AssetItem a = (AssetItem) assetlist[i];
			total += a.getValue();
		}
		return total;
	}
	public String toString()
	{
		Object[] assetlist = assets.toArray();
		String allassets = "";
		for(int i = 0; i < assetlist.length; i++)
		{
			AssetItem current = (AssetItem) assetlist[i];
			allassets = allassets + current.toString() + "\n";
		}
		allassets = allassets + "\nAsset Total: $" + total();
		return allassets;
	}

}
