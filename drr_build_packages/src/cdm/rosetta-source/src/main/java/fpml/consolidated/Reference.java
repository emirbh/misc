package fpml.consolidated;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.meta.ReferenceMeta;


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
@RosettaDataType(value="Reference", builder=Reference.ReferenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Reference", model="fpml", builder=Reference.ReferenceBuilderImpl.class, version="2.1.1")
public interface Reference extends ReferenceType {

	ReferenceMeta metaData = new ReferenceMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Reference build();
	
	Reference.ReferenceBuilder toBuilder();
	
	static Reference.ReferenceBuilder builder() {
		return new Reference.ReferenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Reference> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Reference> getType() {
		return Reference.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
		processor.processBasic(path.newSubPath("type"), String.class, _getType(), this);
		processRosetta(path.newSubPath("transforms"), processor, TransformsType.class, getTransforms());
		processRosetta(path.newSubPath("digestMethod"), processor, DigestMethodType.class, getDigestMethod());
		processor.processBasic(path.newSubPath("digestValue"), String.class, getDigestValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReferenceBuilder extends Reference, ReferenceType.ReferenceTypeBuilder {
		@Override
		Reference.ReferenceBuilder setId(String id);
		@Override
		Reference.ReferenceBuilder setUri(String uri);
		@Override
		Reference.ReferenceBuilder setType(String type);
		@Override
		Reference.ReferenceBuilder setTransforms(TransformsType transforms);
		@Override
		Reference.ReferenceBuilder setDigestMethod(DigestMethodType digestMethod);
		@Override
		Reference.ReferenceBuilder setDigestValue(String digestValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
			processor.processBasic(path.newSubPath("type"), String.class, _getType(), this);
			processRosetta(path.newSubPath("transforms"), processor, TransformsType.TransformsTypeBuilder.class, getTransforms());
			processRosetta(path.newSubPath("digestMethod"), processor, DigestMethodType.DigestMethodTypeBuilder.class, getDigestMethod());
			processor.processBasic(path.newSubPath("digestValue"), String.class, getDigestValue(), this);
		}
		

		Reference.ReferenceBuilder prune();
	}

	/*********************** Immutable Implementation of Reference  ***********************/
	class ReferenceImpl extends ReferenceType.ReferenceTypeImpl implements Reference {
		
		protected ReferenceImpl(Reference.ReferenceBuilder builder) {
			super(builder);
		}
		
		@Override
		public Reference build() {
			return this;
		}
		
		@Override
		public Reference.ReferenceBuilder toBuilder() {
			Reference.ReferenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Reference.ReferenceBuilder builder) {
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
			return "Reference {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Reference  ***********************/
	class ReferenceBuilderImpl extends ReferenceType.ReferenceTypeBuilderImpl implements Reference.ReferenceBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Reference.ReferenceBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("uri")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uri")
		@Override
		public Reference.ReferenceBuilder setUri(String _uri) {
			this.uri = _uri == null ? null : _uri;
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public Reference.ReferenceBuilder setType(String _type) {
			this.type = _type == null ? null : _type;
			return this;
		}
		
		@RosettaAttribute("transforms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transforms")
		@Override
		public Reference.ReferenceBuilder setTransforms(TransformsType _transforms) {
			this.transforms = _transforms == null ? null : _transforms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("digestMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("digestMethod")
		@Override
		public Reference.ReferenceBuilder setDigestMethod(DigestMethodType _digestMethod) {
			this.digestMethod = _digestMethod == null ? null : _digestMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("digestValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("digestValue")
		@Override
		public Reference.ReferenceBuilder setDigestValue(String _digestValue) {
			this.digestValue = _digestValue == null ? null : _digestValue;
			return this;
		}
		
		@Override
		public Reference build() {
			return new Reference.ReferenceImpl(this);
		}
		
		@Override
		public Reference.ReferenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Reference.ReferenceBuilder prune() {
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
		public Reference.ReferenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Reference.ReferenceBuilder o = (Reference.ReferenceBuilder) other;
			
			
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
			return "ReferenceBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
