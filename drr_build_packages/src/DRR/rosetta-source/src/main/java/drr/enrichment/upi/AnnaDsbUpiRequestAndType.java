package drr.enrichment.upi;

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
import drr.enrichment.upi.meta.AnnaDsbUpiRequestAndTypeMeta;
import drr.standards.iosco.upi.AnnaDsbUpiRequest;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbUpiRequestAndType", builder=AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbUpiRequestAndType", model="drr", builder=AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilderImpl.class, version="7.7.0")
public interface AnnaDsbUpiRequestAndType extends RosettaModelObject {

	AnnaDsbUpiRequestAndTypeMeta metaData = new AnnaDsbUpiRequestAndTypeMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbUpiRequest getRequest();
	AnnaDsbUpiRequestTypeEnum getRequestType();

	/*********************** Build Methods  ***********************/
	AnnaDsbUpiRequestAndType build();
	
	AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder toBuilder();
	
	static AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder builder() {
		return new AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbUpiRequestAndType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbUpiRequestAndType> getType() {
		return AnnaDsbUpiRequestAndType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("request"), processor, AnnaDsbUpiRequest.class, getRequest());
		processor.processBasic(path.newSubPath("requestType"), AnnaDsbUpiRequestTypeEnum.class, getRequestType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbUpiRequestAndTypeBuilder extends AnnaDsbUpiRequestAndType, RosettaModelObjectBuilder {
		AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder getOrCreateRequest();
		@Override
		AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder getRequest();
		AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder setRequest(AnnaDsbUpiRequest request);
		AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder setRequestType(AnnaDsbUpiRequestTypeEnum requestType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("request"), processor, AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder.class, getRequest());
			processor.processBasic(path.newSubPath("requestType"), AnnaDsbUpiRequestTypeEnum.class, getRequestType(), this);
		}
		

		AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbUpiRequestAndType  ***********************/
	class AnnaDsbUpiRequestAndTypeImpl implements AnnaDsbUpiRequestAndType {
		private final AnnaDsbUpiRequest request;
		private final AnnaDsbUpiRequestTypeEnum requestType;
		
		protected AnnaDsbUpiRequestAndTypeImpl(AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder builder) {
			this.request = ofNullable(builder.getRequest()).map(f->f.build()).orElse(null);
			this.requestType = builder.getRequestType();
		}
		
		@Override
		@RosettaAttribute("request")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("request")
		public AnnaDsbUpiRequest getRequest() {
			return request;
		}
		
		@Override
		@RosettaAttribute("requestType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("requestType")
		public AnnaDsbUpiRequestTypeEnum getRequestType() {
			return requestType;
		}
		
		@Override
		public AnnaDsbUpiRequestAndType build() {
			return this;
		}
		
		@Override
		public AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder toBuilder() {
			AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder builder) {
			ofNullable(getRequest()).ifPresent(builder::setRequest);
			ofNullable(getRequestType()).ifPresent(builder::setRequestType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUpiRequestAndType _that = getType().cast(o);
		
			if (!Objects.equals(request, _that.getRequest())) return false;
			if (!Objects.equals(requestType, _that.getRequestType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (request != null ? request.hashCode() : 0);
			_result = 31 * _result + (requestType != null ? requestType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUpiRequestAndType {" +
				"request=" + this.request + ", " +
				"requestType=" + this.requestType +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbUpiRequestAndType  ***********************/
	class AnnaDsbUpiRequestAndTypeBuilderImpl implements AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder {
	
		protected AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder request;
		protected AnnaDsbUpiRequestTypeEnum requestType;
		
		@Override
		@RosettaAttribute("request")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("request")
		public AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder getRequest() {
			return request;
		}
		
		@Override
		public AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder getOrCreateRequest() {
			AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder result;
			if (request!=null) {
				result = request;
			}
			else {
				result = request = AnnaDsbUpiRequest.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("requestType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("requestType")
		public AnnaDsbUpiRequestTypeEnum getRequestType() {
			return requestType;
		}
		
		@RosettaAttribute("request")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("request")
		@Override
		public AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder setRequest(AnnaDsbUpiRequest _request) {
			this.request = _request == null ? null : _request.toBuilder();
			return this;
		}
		
		@RosettaAttribute("requestType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("requestType")
		@Override
		public AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder setRequestType(AnnaDsbUpiRequestTypeEnum _requestType) {
			this.requestType = _requestType == null ? null : _requestType;
			return this;
		}
		
		@Override
		public AnnaDsbUpiRequestAndType build() {
			return new AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeImpl(this);
		}
		
		@Override
		public AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder prune() {
			if (request!=null && !request.prune().hasData()) request = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRequest()!=null && getRequest().hasData()) return true;
			if (getRequestType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder o = (AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder) other;
			
			merger.mergeRosetta(getRequest(), o.getRequest(), this::setRequest);
			
			merger.mergeBasic(getRequestType(), o.getRequestType(), this::setRequestType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUpiRequestAndType _that = getType().cast(o);
		
			if (!Objects.equals(request, _that.getRequest())) return false;
			if (!Objects.equals(requestType, _that.getRequestType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (request != null ? request.hashCode() : 0);
			_result = 31 * _result + (requestType != null ? requestType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUpiRequestAndTypeBuilder {" +
				"request=" + this.request + ", " +
				"requestType=" + this.requestType +
			'}';
		}
	}
}
