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
import fpml.consolidated.meta.RetrievalMethodTypeMeta;
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
@RosettaDataType(value="RetrievalMethodType", builder=RetrievalMethodType.RetrievalMethodTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RetrievalMethodType", model="fpml", builder=RetrievalMethodType.RetrievalMethodTypeBuilderImpl.class, version="2.1.1")
public interface RetrievalMethodType extends RosettaModelObject {

	RetrievalMethodTypeMeta metaData = new RetrievalMethodTypeMeta();

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

	/*********************** Build Methods  ***********************/
	RetrievalMethodType build();
	
	RetrievalMethodType.RetrievalMethodTypeBuilder toBuilder();
	
	static RetrievalMethodType.RetrievalMethodTypeBuilder builder() {
		return new RetrievalMethodType.RetrievalMethodTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RetrievalMethodType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RetrievalMethodType> getType() {
		return RetrievalMethodType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
		processor.processBasic(path.newSubPath("type"), String.class, _getType(), this);
		processRosetta(path.newSubPath("transforms"), processor, TransformsType.class, getTransforms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RetrievalMethodTypeBuilder extends RetrievalMethodType, RosettaModelObjectBuilder {
		TransformsType.TransformsTypeBuilder getOrCreateTransforms();
		@Override
		TransformsType.TransformsTypeBuilder getTransforms();
		RetrievalMethodType.RetrievalMethodTypeBuilder setUri(String uri);
		RetrievalMethodType.RetrievalMethodTypeBuilder setType(String type);
		RetrievalMethodType.RetrievalMethodTypeBuilder setTransforms(TransformsType transforms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("uri"), String.class, getUri(), this);
			processor.processBasic(path.newSubPath("type"), String.class, _getType(), this);
			processRosetta(path.newSubPath("transforms"), processor, TransformsType.TransformsTypeBuilder.class, getTransforms());
		}
		

		RetrievalMethodType.RetrievalMethodTypeBuilder prune();
	}

	/*********************** Immutable Implementation of RetrievalMethodType  ***********************/
	class RetrievalMethodTypeImpl implements RetrievalMethodType {
		private final String uri;
		private final String type;
		private final TransformsType transforms;
		
		protected RetrievalMethodTypeImpl(RetrievalMethodType.RetrievalMethodTypeBuilder builder) {
			this.uri = builder.getUri();
			this.type = builder._getType();
			this.transforms = ofNullable(builder.getTransforms()).map(f->f.build()).orElse(null);
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
		public RetrievalMethodType build() {
			return this;
		}
		
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder toBuilder() {
			RetrievalMethodType.RetrievalMethodTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RetrievalMethodType.RetrievalMethodTypeBuilder builder) {
			ofNullable(getUri()).ifPresent(builder::setUri);
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getTransforms()).ifPresent(builder::setTransforms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RetrievalMethodType _that = getType().cast(o);
		
			if (!Objects.equals(uri, _that.getUri())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(transforms, _that.getTransforms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uri != null ? uri.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (transforms != null ? transforms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RetrievalMethodType {" +
				"uri=" + this.uri + ", " +
				"type=" + this.type + ", " +
				"transforms=" + this.transforms +
			'}';
		}
	}

	/*********************** Builder Implementation of RetrievalMethodType  ***********************/
	class RetrievalMethodTypeBuilderImpl implements RetrievalMethodType.RetrievalMethodTypeBuilder {
	
		protected String uri;
		protected String type;
		protected TransformsType.TransformsTypeBuilder transforms;
		
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
		
		@RosettaAttribute("uri")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uri")
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder setUri(String _uri) {
			this.uri = _uri == null ? null : _uri;
			return this;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("type")
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder setType(String _type) {
			this.type = _type == null ? null : _type;
			return this;
		}
		
		@RosettaAttribute("transforms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transforms")
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder setTransforms(TransformsType _transforms) {
			this.transforms = _transforms == null ? null : _transforms.toBuilder();
			return this;
		}
		
		@Override
		public RetrievalMethodType build() {
			return new RetrievalMethodType.RetrievalMethodTypeImpl(this);
		}
		
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder prune() {
			if (transforms!=null && !transforms.prune().hasData()) transforms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUri()!=null) return true;
			if (_getType()!=null) return true;
			if (getTransforms()!=null && getTransforms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RetrievalMethodType.RetrievalMethodTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RetrievalMethodType.RetrievalMethodTypeBuilder o = (RetrievalMethodType.RetrievalMethodTypeBuilder) other;
			
			merger.mergeRosetta(getTransforms(), o.getTransforms(), this::setTransforms);
			
			merger.mergeBasic(getUri(), o.getUri(), this::setUri);
			merger.mergeBasic(_getType(), o._getType(), this::setType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RetrievalMethodType _that = getType().cast(o);
		
			if (!Objects.equals(uri, _that.getUri())) return false;
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(transforms, _that.getTransforms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (uri != null ? uri.hashCode() : 0);
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (transforms != null ? transforms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RetrievalMethodTypeBuilder {" +
				"uri=" + this.uri + ", " +
				"type=" + this.type + ", " +
				"transforms=" + this.transforms +
			'}';
		}
	}
}
