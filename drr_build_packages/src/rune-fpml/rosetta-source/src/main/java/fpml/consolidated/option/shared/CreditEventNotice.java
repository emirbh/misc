package fpml.consolidated.option.shared;

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
import fpml.consolidated.option.shared.meta.CreditEventNoticeMeta;
import fpml.consolidated.shared.BusinessCenter;
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
@RosettaDataType(value="CreditEventNotice", builder=CreditEventNotice.CreditEventNoticeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditEventNotice", model="fpml", builder=CreditEventNotice.CreditEventNoticeBuilderImpl.class, version="2.1.1")
public interface CreditEventNotice extends RosettaModelObject {

	CreditEventNoticeMeta metaData = new CreditEventNoticeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Pointer style references to a party identifier defined elsewhere in the document. The notifying party is the party that notifies the other party when a credit event has occurred by means of a credit event notice. If more than one party is referenced as being the notifying party then either party may notify the other of a credit event occurring. ISDA 2003 Term: Notifying Party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Pointer style references to a party identifier defined elsewhere in the document. The notifying party is the party that notifies the other party when a credit event has occurred by means of a credit event notice. If more than one party is referenced as being the notifying party then either party may notify the other of a credit event occurring. ISDA 2003 Term: Notifying Party.
	 *
	 */
	NotifyingParty getNotifyingParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Inclusion of this business center element implies that Greenwich Mean Time in Section 3.3 of the 2003 ISDA Credit Derivatives Definitions is replaced by the local time of the city indicated by the businessCenter element value.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Inclusion of this business center element implies that Greenwich Mean Time in Section 3.3 of the 2003 ISDA Credit Derivatives Definitions is replaced by the local time of the city indicated by the businessCenter element value.
	 *
	 */
	BusinessCenter getBusinessCenter();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A specified condition to settlement. Publicly available information means information that reasonably confirms any of the facts relevant to determining that a credit event or potential repudiation/moratorium, as applicable, has occurred. The ISDA defined list (2003) is the market standard and is considered comprehensive, and a minimum of two differing public sources must have published the relevant information, to declare a Credit Event. ISDA 2003 Term: Notice of Publicly Available Information Applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A specified condition to settlement. Publicly available information means information that reasonably confirms any of the facts relevant to determining that a credit event or potential repudiation/moratorium, as applicable, has occurred. The ISDA defined list (2003) is the market standard and is considered comprehensive, and a minimum of two differing public sources must have published the relevant information, to declare a Credit Event. ISDA 2003 Term: Notice of Publicly Available Information Applicable.
	 *
	 */
	PubliclyAvailableInformation getPubliclyAvailableInformation();

	/*********************** Build Methods  ***********************/
	CreditEventNotice build();
	
	CreditEventNotice.CreditEventNoticeBuilder toBuilder();
	
	static CreditEventNotice.CreditEventNoticeBuilder builder() {
		return new CreditEventNotice.CreditEventNoticeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditEventNotice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditEventNotice> getType() {
		return CreditEventNotice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notifyingParty"), processor, NotifyingParty.class, getNotifyingParty());
		processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.class, getBusinessCenter());
		processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, PubliclyAvailableInformation.class, getPubliclyAvailableInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditEventNoticeBuilder extends CreditEventNotice, RosettaModelObjectBuilder {
		NotifyingParty.NotifyingPartyBuilder getOrCreateNotifyingParty();
		@Override
		NotifyingParty.NotifyingPartyBuilder getNotifyingParty();
		BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter();
		@Override
		BusinessCenter.BusinessCenterBuilder getBusinessCenter();
		PubliclyAvailableInformation.PubliclyAvailableInformationBuilder getOrCreatePubliclyAvailableInformation();
		@Override
		PubliclyAvailableInformation.PubliclyAvailableInformationBuilder getPubliclyAvailableInformation();
		CreditEventNotice.CreditEventNoticeBuilder setNotifyingParty(NotifyingParty notifyingParty);
		CreditEventNotice.CreditEventNoticeBuilder setBusinessCenter(BusinessCenter businessCenter);
		CreditEventNotice.CreditEventNoticeBuilder setPubliclyAvailableInformation(PubliclyAvailableInformation publiclyAvailableInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notifyingParty"), processor, NotifyingParty.NotifyingPartyBuilder.class, getNotifyingParty());
			processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.BusinessCenterBuilder.class, getBusinessCenter());
			processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, PubliclyAvailableInformation.PubliclyAvailableInformationBuilder.class, getPubliclyAvailableInformation());
		}
		

		CreditEventNotice.CreditEventNoticeBuilder prune();
	}

	/*********************** Immutable Implementation of CreditEventNotice  ***********************/
	class CreditEventNoticeImpl implements CreditEventNotice {
		private final NotifyingParty notifyingParty;
		private final BusinessCenter businessCenter;
		private final PubliclyAvailableInformation publiclyAvailableInformation;
		
		protected CreditEventNoticeImpl(CreditEventNotice.CreditEventNoticeBuilder builder) {
			this.notifyingParty = ofNullable(builder.getNotifyingParty()).map(f->f.build()).orElse(null);
			this.businessCenter = ofNullable(builder.getBusinessCenter()).map(f->f.build()).orElse(null);
			this.publiclyAvailableInformation = ofNullable(builder.getPubliclyAvailableInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notifyingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notifyingParty")
		public NotifyingParty getNotifyingParty() {
			return notifyingParty;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenter")
		public BusinessCenter getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publiclyAvailableInformation")
		public PubliclyAvailableInformation getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		@Override
		public CreditEventNotice build() {
			return this;
		}
		
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder toBuilder() {
			CreditEventNotice.CreditEventNoticeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditEventNotice.CreditEventNoticeBuilder builder) {
			ofNullable(getNotifyingParty()).ifPresent(builder::setNotifyingParty);
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
			ofNullable(getPubliclyAvailableInformation()).ifPresent(builder::setPubliclyAvailableInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEventNotice _that = getType().cast(o);
		
			if (!Objects.equals(notifyingParty, _that.getNotifyingParty())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notifyingParty != null ? notifyingParty.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNotice {" +
				"notifyingParty=" + this.notifyingParty + ", " +
				"businessCenter=" + this.businessCenter + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditEventNotice  ***********************/
	class CreditEventNoticeBuilderImpl implements CreditEventNotice.CreditEventNoticeBuilder {
	
		protected NotifyingParty.NotifyingPartyBuilder notifyingParty;
		protected BusinessCenter.BusinessCenterBuilder businessCenter;
		protected PubliclyAvailableInformation.PubliclyAvailableInformationBuilder publiclyAvailableInformation;
		
		@Override
		@RosettaAttribute("notifyingParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notifyingParty")
		public NotifyingParty.NotifyingPartyBuilder getNotifyingParty() {
			return notifyingParty;
		}
		
		@Override
		public NotifyingParty.NotifyingPartyBuilder getOrCreateNotifyingParty() {
			NotifyingParty.NotifyingPartyBuilder result;
			if (notifyingParty!=null) {
				result = notifyingParty;
			}
			else {
				result = notifyingParty = NotifyingParty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenter")
		public BusinessCenter.BusinessCenterBuilder getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter() {
			BusinessCenter.BusinessCenterBuilder result;
			if (businessCenter!=null) {
				result = businessCenter;
			}
			else {
				result = businessCenter = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publiclyAvailableInformation")
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		@Override
		public PubliclyAvailableInformation.PubliclyAvailableInformationBuilder getOrCreatePubliclyAvailableInformation() {
			PubliclyAvailableInformation.PubliclyAvailableInformationBuilder result;
			if (publiclyAvailableInformation!=null) {
				result = publiclyAvailableInformation;
			}
			else {
				result = publiclyAvailableInformation = PubliclyAvailableInformation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("notifyingParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notifyingParty")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder setNotifyingParty(NotifyingParty _notifyingParty) {
			this.notifyingParty = _notifyingParty == null ? null : _notifyingParty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenter")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder setBusinessCenter(BusinessCenter _businessCenter) {
			this.businessCenter = _businessCenter == null ? null : _businessCenter.toBuilder();
			return this;
		}
		
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("publiclyAvailableInformation")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder setPubliclyAvailableInformation(PubliclyAvailableInformation _publiclyAvailableInformation) {
			this.publiclyAvailableInformation = _publiclyAvailableInformation == null ? null : _publiclyAvailableInformation.toBuilder();
			return this;
		}
		
		@Override
		public CreditEventNotice build() {
			return new CreditEventNotice.CreditEventNoticeImpl(this);
		}
		
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder prune() {
			if (notifyingParty!=null && !notifyingParty.prune().hasData()) notifyingParty = null;
			if (businessCenter!=null && !businessCenter.prune().hasData()) businessCenter = null;
			if (publiclyAvailableInformation!=null && !publiclyAvailableInformation.prune().hasData()) publiclyAvailableInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotifyingParty()!=null && getNotifyingParty().hasData()) return true;
			if (getBusinessCenter()!=null && getBusinessCenter().hasData()) return true;
			if (getPubliclyAvailableInformation()!=null && getPubliclyAvailableInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditEventNotice.CreditEventNoticeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditEventNotice.CreditEventNoticeBuilder o = (CreditEventNotice.CreditEventNoticeBuilder) other;
			
			merger.mergeRosetta(getNotifyingParty(), o.getNotifyingParty(), this::setNotifyingParty);
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::setBusinessCenter);
			merger.mergeRosetta(getPubliclyAvailableInformation(), o.getPubliclyAvailableInformation(), this::setPubliclyAvailableInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditEventNotice _that = getType().cast(o);
		
			if (!Objects.equals(notifyingParty, _that.getNotifyingParty())) return false;
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notifyingParty != null ? notifyingParty.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditEventNoticeBuilder {" +
				"notifyingParty=" + this.notifyingParty + ", " +
				"businessCenter=" + this.businessCenter + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation +
			'}';
		}
	}
}
