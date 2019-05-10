package mx.devlabs.examples

import android.content.ContentValues
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {

    private val DB_NAME : String = "prueba.db"
    private val COMPANY_TABLE : String = "companies"
    private val ID : String = "id"

    private val NAME : String = "name"
    private val DESCRIPTION : String = "description"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null)
                 //$ID INTEGER PRIMARY KEY AUTOINCREMENT,
                 //$ID TEXT PRIMARY KEY NOT NULL,
        db.execSQL("""CREATE TABLE IF NOT EXISTS $COMPANY_TABLE (
                 $NAME TEXT NOT NULL,
                 $DESCRIPTION TEXT)""")

        val values = ContentValues()
        //values.put(ID, UUID.randomUUID().toString())
        values.put(NAME, "macys")
        values.put(DESCRIPTION, "clothing comp.")

        db.insert(
                COMPANY_TABLE,
                null,
                values
                )

        val c = db.rawQuery("SELECT * FROM $COMPANY_TABLE", null)

        while(c.moveToNext()){
            Log.i("DL", "${c.getString(0)}")
            Log.i("DL", "${c.getString(1)}")
            Log.i("DL", "${c.getString(2)}")
        }

        c.close()
        db.close()
    }

}
