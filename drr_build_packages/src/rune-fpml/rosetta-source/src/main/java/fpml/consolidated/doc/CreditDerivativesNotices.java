package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.CreditDerivativesNoticesMeta;
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
@RosettaDataType(value="CreditDerivativesNotices", builder=CreditDerivativesNotices.CreditDerivativesNoticesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditDerivativesNotices", model="fpml", builder=CreditDerivativesNotices.CreditDerivativesNoticesBuilderImpl.class, version="2.1.1")
public interface CreditDerivativesNotices extends RosettaModelObject {

	CreditDerivativesNoticesMeta metaData = new CreditDerivativesNoticesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element corresponds to the Credit Event Notice Delivered Under Old Transaction and Deemed Delivered Under New Transaction under the EXHIBIT C to 2004 ISDA Novation Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element corresponds to the Credit Event Notice Delivered Under Old Transaction and Deemed Delivered Under New Transaction under the EXHIBIT C to 2004 ISDA Novation Definitions.
	 *
	 */
	Boolean getCreditEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element corresponds to the Notice of Publicly Available Information Delivered Under Old Transaction and Deemed Delivered Under New Transaction under the EXHIBIT C to 2004 ISDA Novation Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element corresponds to the Notice of Publicly Available Information Delivered Under Old Transaction and Deemed Delivered Under New Transaction under the EXHIBIT C to 2004 ISDA Novation Definitions.
	 *
	 */
	Boolean getPubliclyAvailableInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element corresponds to the Notice of Intended Physical Settlement Delivered Under Old Transaction under the EXHIBIT C to 2004 ISDA Novation Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element corresponds to the Notice of Intended Physical Settlement Delivered Under Old Transaction under the EXHIBIT C to 2004 ISDA Novation Definitions.
	 *
	 */
	Boolean getPhysicalSettlement();

	/*********************** Build Methods  ***********************/
	CreditDerivativesNotices build();
	
	CreditDerivativesNotices.CreditDerivativesNoticesBuilder toBuilder();
	
	static CreditDerivativesNotices.CreditDerivativesNoticesBuilder builder() {
		return new CreditDerivativesNotices.CreditDerivativesNoticesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditDerivativesNotices> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditDerivativesNotices> getType() {
		return CreditDerivativesNotices.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("creditEvent"), Boolean.class, getCreditEvent(), this);
		processor.processBasic(path.newSubPath("publiclyAvailableInformation"), Boolean.class, getPubliclyAvailableInformation(), this);
		processor.processBasic(path.newSubPath("physicalSettlement"), Boolean.class, getPhysicalSettlement(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditDerivativesNoticesBuilder extends CreditDerivativesNotices, RosettaModelObjectBuilder {
		CreditDerivativesNotices.CreditDerivativesNoticesBuilder setCreditEvent(Boolean creditEvent);
		CreditDerivativesNotices.CreditDerivativesNoticesBuilder setPubliclyAvailableInformation(Boolean publiclyAvailableInformation);
		CreditDerivativesNotices.CreditDerivativesNoticesBuilder setPhysicalSettlement(Boolean physicalSettlement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("creditEvent"), Boolean.class, getCreditEvent(), this);
			processor.processBasic(path.newSubPath("publiclyAvailableInformation"), Boolean.class, getPubliclyAvailableInformation(), this);
			processor.processBasic(path.newSubPath("physicalSettlement"), Boolean.class, getPhysicalSettlement(), this);
		}
		

		CreditDerivativesNotices.CreditDerivativesNoticesBuilder prune();
	}

	/*********************** Immutable Implementation of CreditDerivativesNotices  ***********************/
	class CreditDerivativesNoticesImpl implements CreditDerivativesNotices {
		private final Boolean creditEvent;
		private final Boolean publiclyAvailableInformation;
		private final Boolean physicalSettlement;
		
		protected CreditDerivativesNoticesImpl(CreditDerivativesNotices.CreditDerivativesNoticesBuilder builder) {
			this.creditEvent = builder.getCreditEvent();
			this.publiclyAvailableInformation = builder.getPubliclyAvailableInformation();
			this.physicalSettlement = builder.getPhysicalSettlement();
		}
		
		@Override
		@RosettaAttribute("creditEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEvent")
		public Boolean getCreditEvent() {
			return creditEvent;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publiclyAvailableInformation")
		public Boolean getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlement")
		public Boolean getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		public CreditDerivativesNotices build() {
			return this;
		}
		
		@Override
		public CreditDerivativesNotices.CreditDerivativesNoticesBuilder toBuilder() {
			CreditDerivativesNotices.CreditDerivativesNoticesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditDerivativesNotices.CreditDerivativesNoticesBuilder builder) {
			ofNullable(getCreditEvent()).ifPresent(builder::setCreditEvent);
			ofNullable(getPubliclyAvailableInformation()).ifPresent(builder::setPubliclyAvailableInformation);
			ofNullable(getPhysicalSettlement()).ifPresent(builder::setPhysicalSettlement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditDerivativesNotices _that = getType().cast(o);
		
			if (!Objects.equals(creditEvent, _that.getCreditEvent())) return false;
			if (!Objects.equals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEvent != null ? creditEvent.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDerivativesNotices {" +
				"creditEvent=" + this.creditEvent + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation + ", " +
				"physicalSettlement=" + this.physicalSettlement +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditDerivativesNotices  ***********************/
	class CreditDerivativesNoticesBuilderImpl implements CreditDerivativesNotices.CreditDerivativesNoticesBuilder {
	
		protected Boolean creditEvent;
		protected Boolean publiclyAvailableInformation;
		protected Boolean physicalSettlement;
		
		@Override
		@RosettaAttribute("creditEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEvent")
		public Boolean getCreditEvent() {
			return creditEvent;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publiclyAvailableInformation")
		public Boolean getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlement")
		public Boolean getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@RosettaAttribute("creditEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEvent")
		@Override
		public CreditDerivativesNotices.CreditDerivativesNoticesBuilder setCreditEvent(Boolean _creditEvent) {
			this.creditEvent = _creditEvent == null ? null : _creditEvent;
			return this;
		}
		
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("publiclyAvailableInformation")
		@Override
		public CreditDerivativesNotices.CreditDerivativesNoticesBuilder setPubliclyAvailableInformation(Boolean _publiclyAvailableInformation) {
			this.publiclyAvailableInformation = _publiclyAvailableInformation == null ? null : _publiclyAvailableInformation;
			return this;
		}
		
		@RosettaAttribute("physicalSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalSettlement")
		@Override
		public CreditDerivativesNotices.CreditDerivativesNoticesBuilder setPhysicalSettlement(Boolean _physicalSettlement) {
			this.physicalSettlement = _physicalSettlement == null ? null : _physicalSettlement;
			return this;
		}
		
		@Override
		public CreditDerivativesNotices build() {
			return new CreditDerivativesNotices.CreditDerivativesNoticesImpl(this);
		}
		
		@Override
		public CreditDerivativesNotices.CreditDerivativesNoticesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDerivativesNotices.CreditDerivativesNoticesBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditEvent()!=null) return true;
			if (getPubliclyAvailableInformation()!=null) return true;
			if (getPhysicalSettlement()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDerivativesNotices.CreditDerivativesNoticesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditDerivativesNotices.CreditDerivativesNoticesBuilder o = (CreditDerivativesNotices.CreditDerivativesNoticesBuilder) other;
			
			
			merger.mergeBasic(getCreditEvent(), o.getCreditEvent(), this::setCreditEvent);
			merger.mergeBasic(getPubliclyAvailableInformation(), o.getPubliclyAvailableInformation(), this::setPubliclyAvailableInformation);
			merger.mergeBasic(getPhysicalSettlement(), o.getPhysicalSettlement(), this::setPhysicalSettlement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditDerivativesNotices _that = getType().cast(o);
		
			if (!Objects.equals(creditEvent, _that.getCreditEvent())) return false;
			if (!Objects.equals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEvent != null ? creditEvent.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDerivativesNoticesBuilder {" +
				"creditEvent=" + this.creditEvent + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation + ", " +
				"physicalSettlement=" + this.physicalSettlement +
			'}';
		}
	}
}
