package rajawali.primitives;

import rajawali.BaseObject3D;
import rajawali.materials.ParticleMaterial;
import android.opengl.GLES20;


public class Particle extends BaseObject3D {
	private float mPointSize = 10.0f;
	private ParticleMaterial mParticleShader;
	
	public Particle() {
		super();
		init();
	}
	
	public void setPointSize(float pointSize) {
		mPointSize = pointSize;
	}
	
	public float getPointSize() {
		return mPointSize;
	}
	
	private void init() {
		mMaterial = new ParticleMaterial();
		mParticleShader = (ParticleMaterial)mMaterial;
		setDrawingMode(GLES20.GL_POINTS);
		setTransparent(true);
		
		float[] vertices = new float[] {
			0, 0, 0	        
		};
		float[] textureCoords = new float[] {
			0, 0, 0
		};
		float[] normals = new float[] {
			0.0f, 0.0f, 1.0f
		};
		float[] colors = new float[] {
			1.0f, 1.0f, 1.0f, 1.0f	
		};
		short[] indices = new short[] {
			0
		};
		
		setData(vertices, normals, textureCoords, colors, indices);
	}
	
	@Override
	protected void setShaderParams() {
		mParticleShader.setPointSize(mPointSize);
	}
}
