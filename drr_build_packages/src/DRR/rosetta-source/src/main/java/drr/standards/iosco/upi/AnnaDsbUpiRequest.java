package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbUpiRequestMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbUpiRequest", builder=AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbUpiRequest", model="drr", builder=AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilderImpl.class, version="7.7.0")
public interface AnnaDsbUpiRequest extends RosettaModelObject {

	AnnaDsbUpiRequestMeta metaData = new AnnaDsbUpiRequestMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbHeader getHeader();
	AnnaDsbAttributes getAttributes();

	/*********************** Build Methods  ***********************/
	AnnaDsbUpiRequest build();
	
	AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder toBuilder();
	
	static AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder builder() {
		return new AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbUpiRequest> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbUpiRequest> getType() {
		return AnnaDsbUpiRequest.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Header"), processor, AnnaDsbHeader.class, getHeader());
		processRosetta(path.newSubPath("Attributes"), processor, AnnaDsbAttributes.class, getAttributes());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbUpiRequestBuilder extends AnnaDsbUpiRequest, RosettaModelObjectBuilder {
		AnnaDsbHeader.AnnaDsbHeaderBuilder getOrCreateHeader();
		@Override
		AnnaDsbHeader.AnnaDsbHeaderBuilder getHeader();
		AnnaDsbAttributes.AnnaDsbAttributesBuilder getOrCreateAttributes();
		@Override
		AnnaDsbAttributes.AnnaDsbAttributesBuilder getAttributes();
		AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder setHeader(AnnaDsbHeader Header);
		AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder setAttributes(AnnaDsbAttributes Attributes);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Header"), processor, AnnaDsbHeader.AnnaDsbHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("Attributes"), processor, AnnaDsbAttributes.AnnaDsbAttributesBuilder.class, getAttributes());
		}
		

		AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbUpiRequest  ***********************/
	class AnnaDsbUpiRequestImpl implements AnnaDsbUpiRequest {
		private final AnnaDsbHeader header;
		private final AnnaDsbAttributes attributes;
		
		protected AnnaDsbUpiRequestImpl(AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder builder) {
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.attributes = ofNullable(builder.getAttributes()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("Header")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Header")
		public AnnaDsbHeader getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("Attributes")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Attributes")
		public AnnaDsbAttributes getAttributes() {
			return attributes;
		}
		
		@Override
		public AnnaDsbUpiRequest build() {
			return this;
		}
		
		@Override
		public AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder toBuilder() {
			AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder builder) {
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getAttributes()).ifPresent(builder::setAttributes);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUpiRequest _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(attributes, _that.getAttributes())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (attributes != null ? attributes.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUpiRequest {" +
				"Header=" + this.header + ", " +
				"Attributes=" + this.attributes +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbUpiRequest  ***********************/
	class AnnaDsbUpiRequestBuilderImpl implements AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder {
	
		protected AnnaDsbHeader.AnnaDsbHeaderBuilder header;
		protected AnnaDsbAttributes.AnnaDsbAttributesBuilder attributes;
		
		@Override
		@RosettaAttribute("Header")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Header")
		public AnnaDsbHeader.AnnaDsbHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public AnnaDsbHeader.AnnaDsbHeaderBuilder getOrCreateHeader() {
			AnnaDsbHeader.AnnaDsbHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = AnnaDsbHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Attributes")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Attributes")
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder getAttributes() {
			return attributes;
		}
		
		@Override
		public AnnaDsbAttributes.AnnaDsbAttributesBuilder getOrCreateAttributes() {
			AnnaDsbAttributes.AnnaDsbAttributesBuilder result;
			if (attributes!=null) {
				result = attributes;
			}
			else {
				result = attributes = AnnaDsbAttributes.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("Header")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("Header")
		@Override
		public AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder setHeader(AnnaDsbHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Attributes")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("Attributes")
		@Override
		public AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder setAttributes(AnnaDsbAttributes _attributes) {
			this.attributes = _attributes == null ? null : _attributes.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbUpiRequest build() {
			return new AnnaDsbUpiRequest.AnnaDsbUpiRequestImpl(this);
		}
		
		@Override
		public AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder prune() {
			if (header!=null && !header.prune().hasData()) header = null;
			if (attributes!=null && !attributes.prune().hasData()) attributes = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getAttributes()!=null && getAttributes().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder o = (AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getAttributes(), o.getAttributes(), this::setAttributes);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUpiRequest _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(attributes, _that.getAttributes())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (attributes != null ? attributes.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUpiRequestBuilder {" +
				"Header=" + this.header + ", " +
				"Attributes=" + this.attributes +
			'}';
		}
	}
}
