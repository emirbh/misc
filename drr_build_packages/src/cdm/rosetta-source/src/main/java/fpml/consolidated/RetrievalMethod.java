package fpml.consolidated;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.meta.RetrievalMethodMeta;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="RetrievalMethod", builder=RetrievalMethod.RetrievalMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RetrievalMethod", model="fpml", builder=RetrievalMethod.RetrievalMethodBuilderImpl.class, version="2.1.1")
public interface RetrievalMethod extends RetrievalMethodType {

	RetrievalMethodMeta metaData = new RetrievalMethodMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	RetrievalMethod build();
	
	RetrievalMethod.RetrievalMethodBuilder toBuilder();
	
	static RetrievalMethod.RetrievalMethodBuilder builder() {
		return new RetrievalMethod.RetrievalMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RetrievalMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RetrievalMethod> getType() {
		return RetrievalMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
		processor.processBasic(path.newSubPath("type"), String.class, _getType(), this);
		processRosetta(path.newSubPath("transforms"), processor, TransformsType.class, getTransforms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RetrievalMethodBuilder extends RetrievalMethod, RetrievalMethodType.RetrievalMethodTypeBuilder {
		@Override
		RetrievalMethod.RetrievalMethodBuilder setUri(String uri);
		@Override
		RetrievalMethod.RetrievalMethodBuilder setType(String type);
		@Override
		RetrievalMethod.RetrievalMethodBuilder setTransforms(TransformsType transforms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
			processor.processBasic(path.newSubPath("type"), String.class, _getType(), this);
			processRosetta(path.newSubPath("transforms"), processor, TransformsType.TransformsTypeBuilder.class, getTransforms());
		}
		

		RetrievalMethod.RetrievalMethodBuilder prune();
	}

	/*********************** Immutable Implementation of RetrievalMethod  ***********************/
	class RetrievalMethodImpl extends RetrievalMethodType.RetrievalMethodTypeImpl implements RetrievalMethod {
		
		protected RetrievalMethodImpl(RetrievalMethod.RetrievalMethodBuilder builder) {
			super(builder);
		}
		
		@Override
		public RetrievalMethod build() {
			return this;
		}
		
		@Override
		public RetrievalMethod.RetrievalMethodBuilder toBuilder() {
			RetrievalMethod.RetrievalMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RetrievalMethod.RetrievalMethodBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RetrievalMethod {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RetrievalMethod  ***********************/
	class RetrievalMethodBuilderImpl extends RetrievalMethodType.RetrievalMethodTypeBuilderImpl implements RetrievalMethod.RetrievalMethodBuilder {
	
		
		@RosettaAttribute("uri")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uri")
		@Override
		public RetrievalMethod.RetrievalMethodBuilder setUri(String _uri) {
			this.uri = _uri == null ? null : _uri;
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public RetrievalMethod.RetrievalMethodBuilder setType(String _type) {
			this.type = _type == null ? null : _type;
			return this;
		}
		
		@RosettaAttribute("transforms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transforms")
		@Override
		public RetrievalMethod.RetrievalMethodBuilder setTransforms(TransformsType _transforms) {
			this.transforms = _transforms == null ? null : _transforms.toBuilder();
			return this;
		}
		
		@Override
		public RetrievalMethod build() {
			return new RetrievalMethod.RetrievalMethodImpl(this);
		}
		
		@Override
		public RetrievalMethod.RetrievalMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RetrievalMethod.RetrievalMethodBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RetrievalMethod.RetrievalMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RetrievalMethod.RetrievalMethodBuilder o = (RetrievalMethod.RetrievalMethodBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "RetrievalMethodBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
