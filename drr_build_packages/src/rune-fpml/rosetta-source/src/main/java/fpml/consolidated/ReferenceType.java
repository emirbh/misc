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
import fpml.consolidated.meta.ReferenceTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

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
@RosettaDataType(value="ReferenceType", builder=ReferenceType.ReferenceTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ReferenceType", model="fpml", builder=ReferenceType.ReferenceTypeBuilderImpl.class, version="2.1.1")
public interface ReferenceType extends RosettaModelObject {

	ReferenceTypeMeta metaData = new ReferenceTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	String getId();
	/**
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
	String getUri();
	/**
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
	String _getType();
	/**
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
	TransformsType getTransforms();
	/**
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
	DigestMethodType getDigestMethod();
	/**
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
	String getDigestValue();

	/*********************** Build Methods  ***********************/
	ReferenceType build();
	
	ReferenceType.ReferenceTypeBuilder toBuilder();
	
	static ReferenceType.ReferenceTypeBuilder builder() {
		return new ReferenceType.ReferenceTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReferenceType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReferenceType> getType() {
		return ReferenceType.class;
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
	interface ReferenceTypeBuilder extends ReferenceType, RosettaModelObjectBuilder {
		TransformsType.TransformsTypeBuilder getOrCreateTransforms();
		@Override
		TransformsType.TransformsTypeBuilder getTransforms();
		DigestMethodType.DigestMethodTypeBuilder getOrCreateDigestMethod();
		@Override
		DigestMethodType.DigestMethodTypeBuilder getDigestMethod();
		ReferenceType.ReferenceTypeBuilder setId(String id);
		ReferenceType.ReferenceTypeBuilder setUri(String uri);
		ReferenceType.ReferenceTypeBuilder setType(String type);
		ReferenceType.ReferenceTypeBuilder setTransforms(TransformsType transforms);
		ReferenceType.ReferenceTypeBuilder setDigestMethod(DigestMethodType digestMethod);
		ReferenceType.ReferenceTypeBuilder setDigestValue(String digestValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
			processor.processBasic(path.newSubPath("type"), String.class, _getType(), this);
			processRosetta(path.newSubPath("transforms"), processor, TransformsType.TransformsTypeBuilder.class, getTransforms());
			processRosetta(path.newSubPath("digestMethod"), processor, DigestMethodType.DigestMethodTypeBuilder.class, getDigestMethod());
			processor.processBasic(path.newSubPath("digestValue"), String.class, getDigestValue(), this);
		}
		

		ReferenceType.ReferenceTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ReferenceType  ***********************/
	class ReferenceTypeImpl implements ReferenceType {
		private final String id;
		private final String uri;
		private final String type;
		private final TransformsType transforms;
		private final DigestMethodType digestMethod;
		private final String digestValue;
		
		protected ReferenceTypeImpl(ReferenceType.ReferenceTypeBuilder builder) {
			this.id = builder.getId();
			this.uri = builder.getUri();
			this.type = builder._getType();
			this.transforms = ofNullable(builder.getTransforms()).map(f->f.build()).orElse(null);
			this.digestMethod = ofNullable(builder.getDigestMethod()).map(f->f.build()).orElse(null);
			this.digestValue = builder.getDigestValue();
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("uri")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uri")
		public String getUri() {
			return uri;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public String _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("transforms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transforms")
		public TransformsType getTransforms() {
			return transforms;
		}
		
		@Override
		@RosettaAttribute("digestMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("digestMethod")
		public DigestMethodType getDigestMethod() {
			return digestMethod;
		}
		
		@Override
		@RosettaAttribute("digestValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("digestValue")
		public String getDigestValue() {
			return digestValue;
		}
		
		@Override
		public ReferenceType build() {
			return this;
		}
		
		@Override
		public ReferenceType.ReferenceTypeBuilder toBuilder() {
			ReferenceType.ReferenceTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceType.ReferenceTypeBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getUri()).ifPresent(builder::setUri);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getTransforms()).ifPresent(builder::setTransforms);
			ofNullable(getDigestMethod()).ifPresent(builder::setDigestMethod);
			ofNullable(getDigestValue()).ifPresent(builder::setDigestValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(uri, _that.getUri())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(transforms, _that.getTransforms())) return false;
			if (!Objects.equals(digestMethod, _that.getDigestMethod())) return false;
			if (!Objects.equals(digestValue, _that.getDigestValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (uri != null ? uri.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (transforms != null ? transforms.hashCode() : 0);
			_result = 31 * _result + (digestMethod != null ? digestMethod.hashCode() : 0);
			_result = 31 * _result + (digestValue != null ? digestValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceType {" +
				"id=" + this.id + ", " +
				"uri=" + this.uri + ", " +
				"type=" + this.type + ", " +
				"transforms=" + this.transforms + ", " +
				"digestMethod=" + this.digestMethod + ", " +
				"digestValue=" + this.digestValue +
			'}';
		}
	}

	/*********************** Builder Implementation of ReferenceType  ***********************/
	class ReferenceTypeBuilderImpl implements ReferenceType.ReferenceTypeBuilder {
	
		protected String id;
		protected String uri;
		protected String type;
		protected TransformsType.TransformsTypeBuilder transforms;
		protected DigestMethodType.DigestMethodTypeBuilder digestMethod;
		protected String digestValue;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("uri")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uri")
		public String getUri() {
			return uri;
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("type")
		public String _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("transforms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transforms")
		public TransformsType.TransformsTypeBuilder getTransforms() {
			return transforms;
		}
		
		@Override
		public TransformsType.TransformsTypeBuilder getOrCreateTransforms() {
			TransformsType.TransformsTypeBuilder result;
			if (transforms!=null) {
				result = transforms;
			}
			else {
				result = transforms = TransformsType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("digestMethod")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("digestMethod")
		public DigestMethodType.DigestMethodTypeBuilder getDigestMethod() {
			return digestMethod;
		}
		
		@Override
		public DigestMethodType.DigestMethodTypeBuilder getOrCreateDigestMethod() {
			DigestMethodType.DigestMethodTypeBuilder result;
			if (digestMethod!=null) {
				result = digestMethod;
			}
			else {
				result = digestMethod = DigestMethodType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("digestValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("digestValue")
		public String getDigestValue() {
			return digestValue;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ReferenceType.ReferenceTypeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("uri")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uri")
		@Override
		public ReferenceType.ReferenceTypeBuilder setUri(String _uri) {
			this.uri = _uri == null ? null : _uri;
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public ReferenceType.ReferenceTypeBuilder setType(String _type) {
			this.type = _type == null ? null : _type;
			return this;
		}
		
		@RosettaAttribute("transforms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transforms")
		@Override
		public ReferenceType.ReferenceTypeBuilder setTransforms(TransformsType _transforms) {
			this.transforms = _transforms == null ? null : _transforms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("digestMethod")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("digestMethod")
		@Override
		public ReferenceType.ReferenceTypeBuilder setDigestMethod(DigestMethodType _digestMethod) {
			this.digestMethod = _digestMethod == null ? null : _digestMethod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("digestValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("digestValue")
		@Override
		public ReferenceType.ReferenceTypeBuilder setDigestValue(String _digestValue) {
			this.digestValue = _digestValue == null ? null : _digestValue;
			return this;
		}
		
		@Override
		public ReferenceType build() {
			return new ReferenceType.ReferenceTypeImpl(this);
		}
		
		@Override
		public ReferenceType.ReferenceTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceType.ReferenceTypeBuilder prune() {
			if (transforms!=null && !transforms.prune().hasData()) transforms = null;
			if (digestMethod!=null && !digestMethod.prune().hasData()) digestMethod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getUri()!=null) return true;
			if (_getType()!=null) return true;
			if (getTransforms()!=null && getTransforms().hasData()) return true;
			if (getDigestMethod()!=null && getDigestMethod().hasData()) return true;
			if (getDigestValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceType.ReferenceTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceType.ReferenceTypeBuilder o = (ReferenceType.ReferenceTypeBuilder) other;
			
			merger.mergeRosetta(getTransforms(), o.getTransforms(), this::setTransforms);
			merger.mergeRosetta(getDigestMethod(), o.getDigestMethod(), this::setDigestMethod);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getUri(), o.getUri(), this::setUri);
			merger.mergeBasic(_getType(), o._getType(), this::setType);
			merger.mergeBasic(getDigestValue(), o.getDigestValue(), this::setDigestValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceType _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(uri, _that.getUri())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(transforms, _that.getTransforms())) return false;
			if (!Objects.equals(digestMethod, _that.getDigestMethod())) return false;
			if (!Objects.equals(digestValue, _that.getDigestValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (uri != null ? uri.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (transforms != null ? transforms.hashCode() : 0);
			_result = 31 * _result + (digestMethod != null ? digestMethod.hashCode() : 0);
			_result = 31 * _result + (digestValue != null ? digestValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceTypeBuilder {" +
				"id=" + this.id + ", " +
				"uri=" + this.uri + ", " +
				"type=" + this.type + ", " +
				"transforms=" + this.transforms + ", " +
				"digestMethod=" + this.digestMethod + ", " +
				"digestValue=" + this.digestValue +
			'}';
		}
	}
}
