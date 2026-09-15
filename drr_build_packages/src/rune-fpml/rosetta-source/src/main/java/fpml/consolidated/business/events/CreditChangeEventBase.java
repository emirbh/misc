package fpml.consolidated.business.events;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.business.events.meta.CreditChangeEventBaseMeta;
import fpml.consolidated.shared.Resource;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A structure indicating that a trade has changed due to a credit event and containing only components shared by single name, index and basket.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure indicating that a trade has changed due to a credit event and containing only components shared by single name, index and basket.
 *
 */
@RosettaDataType(value="CreditChangeEventBase", builder=CreditChangeEventBase.CreditChangeEventBaseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditChangeEventBase", model="fpml", builder=CreditChangeEventBase.CreditChangeEventBaseBuilderImpl.class, version="2.1.1")
public interface CreditChangeEventBase extends ChangeEvent {

	CreditChangeEventBaseMeta metaData = new CreditChangeEventBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the type of credit event taking place.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the type of credit event taking place.
	 *
	 */
	CreditEventType getCreditEventType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date at which a Credit Event Resolution Request Date (CERD) or Notice Delivery Date occurs.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date at which a Credit Event Resolution Request Date (CERD) or Notice Delivery Date occurs.
	 *
	 */
	ZonedDateTime getEventDeterminationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which the auction is scheduled to occur.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which the auction is scheduled to occur.
	 *
	 */
	ZonedDateTime getAuctionDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the process is to be physically settled or cash settled.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the process is to be physically settled or cash settled.
	 *
	 */
	CashOrPhysicalSettlementEnum getSettlementMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date on which settlement is scheduled to occur.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date on which settlement is scheduled to occur.
	 *
	 */
	ZonedDateTime getSettlementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The final price resulting from the auction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The final price resulting from the auction.
	 *
	 */
	BigDecimal getFinalPrice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The percentage of the original value of the asset affected by the credit event that can be recovered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The percentage of the original value of the asset affected by the credit event that can be recovered.
	 *
	 */
	BigDecimal getRecoveryPercent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A public information source, e.g. a particular newspaper or electronic news service, that may publish relevant information used in the determination of whether or not a credit event has occurred.
	 *
	 */
	List<? extends Resource> getPubliclyAvailableInformation();

	/*********************** Build Methods  ***********************/
	CreditChangeEventBase build();
	
	CreditChangeEventBase.CreditChangeEventBaseBuilder toBuilder();
	
	static CreditChangeEventBase.CreditChangeEventBaseBuilder builder() {
		return new CreditChangeEventBase.CreditChangeEventBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditChangeEventBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditChangeEventBase> getType() {
		return CreditChangeEventBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("creditEventType"), processor, CreditEventType.class, getCreditEventType());
		processor.processBasic(path.newSubPath("eventDeterminationDate"), ZonedDateTime.class, getEventDeterminationDate(), this);
		processor.processBasic(path.newSubPath("auctionDate"), ZonedDateTime.class, getAuctionDate(), this);
		processor.processBasic(path.newSubPath("settlementMethod"), CashOrPhysicalSettlementEnum.class, getSettlementMethod(), this);
		processor.processBasic(path.newSubPath("settlementDate"), ZonedDateTime.class, getSettlementDate(), this);
		processor.processBasic(path.newSubPath("finalPrice"), BigDecimal.class, getFinalPrice(), this);
		processor.processBasic(path.newSubPath("recoveryPercent"), BigDecimal.class, getRecoveryPercent(), this);
		processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, Resource.class, getPubliclyAvailableInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditChangeEventBaseBuilder extends CreditChangeEventBase, ChangeEvent.ChangeEventBuilder {
		CreditEventType.CreditEventTypeBuilder getOrCreateCreditEventType();
		@Override
		CreditEventType.CreditEventTypeBuilder getCreditEventType();
		Resource.ResourceBuilder getOrCreatePubliclyAvailableInformation(int index);
		@Override
		List<? extends Resource.ResourceBuilder> getPubliclyAvailableInformation();
		@Override
		CreditChangeEventBase.CreditChangeEventBaseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		CreditChangeEventBase.CreditChangeEventBaseBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		CreditChangeEventBase.CreditChangeEventBaseBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		CreditChangeEventBase.CreditChangeEventBaseBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		CreditChangeEventBase.CreditChangeEventBaseBuilder setCreditEventType(CreditEventType creditEventType);
		CreditChangeEventBase.CreditChangeEventBaseBuilder setEventDeterminationDate(ZonedDateTime eventDeterminationDate);
		CreditChangeEventBase.CreditChangeEventBaseBuilder setAuctionDate(ZonedDateTime auctionDate);
		CreditChangeEventBase.CreditChangeEventBaseBuilder setSettlementMethod(CashOrPhysicalSettlementEnum settlementMethod);
		CreditChangeEventBase.CreditChangeEventBaseBuilder setSettlementDate(ZonedDateTime settlementDate);
		CreditChangeEventBase.CreditChangeEventBaseBuilder setFinalPrice(BigDecimal finalPrice);
		CreditChangeEventBase.CreditChangeEventBaseBuilder setRecoveryPercent(BigDecimal recoveryPercent);
		CreditChangeEventBase.CreditChangeEventBaseBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation);
		CreditChangeEventBase.CreditChangeEventBaseBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation, int idx);
		CreditChangeEventBase.CreditChangeEventBaseBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation);
		CreditChangeEventBase.CreditChangeEventBaseBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("creditEventType"), processor, CreditEventType.CreditEventTypeBuilder.class, getCreditEventType());
			processor.processBasic(path.newSubPath("eventDeterminationDate"), ZonedDateTime.class, getEventDeterminationDate(), this);
			processor.processBasic(path.newSubPath("auctionDate"), ZonedDateTime.class, getAuctionDate(), this);
			processor.processBasic(path.newSubPath("settlementMethod"), CashOrPhysicalSettlementEnum.class, getSettlementMethod(), this);
			processor.processBasic(path.newSubPath("settlementDate"), ZonedDateTime.class, getSettlementDate(), this);
			processor.processBasic(path.newSubPath("finalPrice"), BigDecimal.class, getFinalPrice(), this);
			processor.processBasic(path.newSubPath("recoveryPercent"), BigDecimal.class, getRecoveryPercent(), this);
			processRosetta(path.newSubPath("publiclyAvailableInformation"), processor, Resource.ResourceBuilder.class, getPubliclyAvailableInformation());
		}
		

		CreditChangeEventBase.CreditChangeEventBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CreditChangeEventBase  ***********************/
	class CreditChangeEventBaseImpl extends ChangeEvent.ChangeEventImpl implements CreditChangeEventBase {
		private final CreditEventType creditEventType;
		private final ZonedDateTime eventDeterminationDate;
		private final ZonedDateTime auctionDate;
		private final CashOrPhysicalSettlementEnum settlementMethod;
		private final ZonedDateTime settlementDate;
		private final BigDecimal finalPrice;
		private final BigDecimal recoveryPercent;
		private final List<? extends Resource> publiclyAvailableInformation;
		
		protected CreditChangeEventBaseImpl(CreditChangeEventBase.CreditChangeEventBaseBuilder builder) {
			super(builder);
			this.creditEventType = ofNullable(builder.getCreditEventType()).map(f->f.build()).orElse(null);
			this.eventDeterminationDate = builder.getEventDeterminationDate();
			this.auctionDate = builder.getAuctionDate();
			this.settlementMethod = builder.getSettlementMethod();
			this.settlementDate = builder.getSettlementDate();
			this.finalPrice = builder.getFinalPrice();
			this.recoveryPercent = builder.getRecoveryPercent();
			this.publiclyAvailableInformation = ofNullable(builder.getPubliclyAvailableInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("creditEventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEventType")
		public CreditEventType getCreditEventType() {
			return creditEventType;
		}
		
		@Override
		@RosettaAttribute("eventDeterminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventDeterminationDate")
		public ZonedDateTime getEventDeterminationDate() {
			return eventDeterminationDate;
		}
		
		@Override
		@RosettaAttribute("auctionDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("auctionDate")
		public ZonedDateTime getAuctionDate() {
			return auctionDate;
		}
		
		@Override
		@RosettaAttribute("settlementMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementMethod")
		public CashOrPhysicalSettlementEnum getSettlementMethod() {
			return settlementMethod;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public ZonedDateTime getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("finalPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalPrice")
		public BigDecimal getFinalPrice() {
			return finalPrice;
		}
		
		@Override
		@RosettaAttribute("recoveryPercent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recoveryPercent")
		public BigDecimal getRecoveryPercent() {
			return recoveryPercent;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("publiclyAvailableInformation")
		public List<? extends Resource> getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		@Override
		public CreditChangeEventBase build() {
			return this;
		}
		
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder toBuilder() {
			CreditChangeEventBase.CreditChangeEventBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditChangeEventBase.CreditChangeEventBaseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCreditEventType()).ifPresent(builder::setCreditEventType);
			ofNullable(getEventDeterminationDate()).ifPresent(builder::setEventDeterminationDate);
			ofNullable(getAuctionDate()).ifPresent(builder::setAuctionDate);
			ofNullable(getSettlementMethod()).ifPresent(builder::setSettlementMethod);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getFinalPrice()).ifPresent(builder::setFinalPrice);
			ofNullable(getRecoveryPercent()).ifPresent(builder::setRecoveryPercent);
			ofNullable(getPubliclyAvailableInformation()).ifPresent(builder::setPubliclyAvailableInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditChangeEventBase _that = getType().cast(o);
		
			if (!Objects.equals(creditEventType, _that.getCreditEventType())) return false;
			if (!Objects.equals(eventDeterminationDate, _that.getEventDeterminationDate())) return false;
			if (!Objects.equals(auctionDate, _that.getAuctionDate())) return false;
			if (!Objects.equals(settlementMethod, _that.getSettlementMethod())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(finalPrice, _that.getFinalPrice())) return false;
			if (!Objects.equals(recoveryPercent, _that.getRecoveryPercent())) return false;
			if (!ListEquals.listEquals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditEventType != null ? creditEventType.hashCode() : 0);
			_result = 31 * _result + (eventDeterminationDate != null ? eventDeterminationDate.hashCode() : 0);
			_result = 31 * _result + (auctionDate != null ? auctionDate.hashCode() : 0);
			_result = 31 * _result + (settlementMethod != null ? settlementMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (finalPrice != null ? finalPrice.hashCode() : 0);
			_result = 31 * _result + (recoveryPercent != null ? recoveryPercent.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditChangeEventBase {" +
				"creditEventType=" + this.creditEventType + ", " +
				"eventDeterminationDate=" + this.eventDeterminationDate + ", " +
				"auctionDate=" + this.auctionDate + ", " +
				"settlementMethod=" + this.settlementMethod + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"finalPrice=" + this.finalPrice + ", " +
				"recoveryPercent=" + this.recoveryPercent + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditChangeEventBase  ***********************/
	class CreditChangeEventBaseBuilderImpl extends ChangeEvent.ChangeEventBuilderImpl implements CreditChangeEventBase.CreditChangeEventBaseBuilder {
	
		protected CreditEventType.CreditEventTypeBuilder creditEventType;
		protected ZonedDateTime eventDeterminationDate;
		protected ZonedDateTime auctionDate;
		protected CashOrPhysicalSettlementEnum settlementMethod;
		protected ZonedDateTime settlementDate;
		protected BigDecimal finalPrice;
		protected BigDecimal recoveryPercent;
		protected List<Resource.ResourceBuilder> publiclyAvailableInformation = new ArrayList<>();
		
		@Override
		@RosettaAttribute("creditEventType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEventType")
		public CreditEventType.CreditEventTypeBuilder getCreditEventType() {
			return creditEventType;
		}
		
		@Override
		public CreditEventType.CreditEventTypeBuilder getOrCreateCreditEventType() {
			CreditEventType.CreditEventTypeBuilder result;
			if (creditEventType!=null) {
				result = creditEventType;
			}
			else {
				result = creditEventType = CreditEventType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventDeterminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("eventDeterminationDate")
		public ZonedDateTime getEventDeterminationDate() {
			return eventDeterminationDate;
		}
		
		@Override
		@RosettaAttribute("auctionDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("auctionDate")
		public ZonedDateTime getAuctionDate() {
			return auctionDate;
		}
		
		@Override
		@RosettaAttribute("settlementMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementMethod")
		public CashOrPhysicalSettlementEnum getSettlementMethod() {
			return settlementMethod;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public ZonedDateTime getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("finalPrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("finalPrice")
		public BigDecimal getFinalPrice() {
			return finalPrice;
		}
		
		@Override
		@RosettaAttribute("recoveryPercent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("recoveryPercent")
		public BigDecimal getRecoveryPercent() {
			return recoveryPercent;
		}
		
		@Override
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("publiclyAvailableInformation")
		public List<? extends Resource.ResourceBuilder> getPubliclyAvailableInformation() {
			return publiclyAvailableInformation;
		}
		
		@Override
		public Resource.ResourceBuilder getOrCreatePubliclyAvailableInformation(int index) {
			if (publiclyAvailableInformation==null) {
				this.publiclyAvailableInformation = new ArrayList<>();
			}
			return getIndex(publiclyAvailableInformation, index, () -> {
						Resource.ResourceBuilder newPubliclyAvailableInformation = Resource.builder();
						return newPubliclyAvailableInformation;
					});
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("creditEventType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEventType")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder setCreditEventType(CreditEventType _creditEventType) {
			this.creditEventType = _creditEventType == null ? null : _creditEventType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventDeterminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDeterminationDate")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder setEventDeterminationDate(ZonedDateTime _eventDeterminationDate) {
			this.eventDeterminationDate = _eventDeterminationDate == null ? null : _eventDeterminationDate;
			return this;
		}
		
		@RosettaAttribute("auctionDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("auctionDate")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder setAuctionDate(ZonedDateTime _auctionDate) {
			this.auctionDate = _auctionDate == null ? null : _auctionDate;
			return this;
		}
		
		@RosettaAttribute("settlementMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementMethod")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder setSettlementMethod(CashOrPhysicalSettlementEnum _settlementMethod) {
			this.settlementMethod = _settlementMethod == null ? null : _settlementMethod;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder setSettlementDate(ZonedDateTime _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate;
			return this;
		}
		
		@RosettaAttribute("finalPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalPrice")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder setFinalPrice(BigDecimal _finalPrice) {
			this.finalPrice = _finalPrice == null ? null : _finalPrice;
			return this;
		}
		
		@RosettaAttribute("recoveryPercent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("recoveryPercent")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder setRecoveryPercent(BigDecimal _recoveryPercent) {
			this.recoveryPercent = _recoveryPercent == null ? null : _recoveryPercent;
			return this;
		}
		
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("publiclyAvailableInformation")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder addPubliclyAvailableInformation(Resource _publiclyAvailableInformation) {
			if (_publiclyAvailableInformation != null) {
				this.publiclyAvailableInformation.add(_publiclyAvailableInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder addPubliclyAvailableInformation(Resource _publiclyAvailableInformation, int idx) {
			getIndex(this.publiclyAvailableInformation, idx, () -> _publiclyAvailableInformation.toBuilder());
			return this;
		}
		
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
			if (publiclyAvailableInformations != null) {
				for (final Resource toAdd : publiclyAvailableInformations) {
					this.publiclyAvailableInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("publiclyAvailableInformation")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
			if (publiclyAvailableInformations == null) {
				this.publiclyAvailableInformation = new ArrayList<>();
			} else {
				this.publiclyAvailableInformation = publiclyAvailableInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditChangeEventBase build() {
			return new CreditChangeEventBase.CreditChangeEventBaseImpl(this);
		}
		
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder prune() {
			super.prune();
			if (creditEventType!=null && !creditEventType.prune().hasData()) creditEventType = null;
			publiclyAvailableInformation = publiclyAvailableInformation.stream().filter(b->b!=null).<Resource.ResourceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCreditEventType()!=null && getCreditEventType().hasData()) return true;
			if (getEventDeterminationDate()!=null) return true;
			if (getAuctionDate()!=null) return true;
			if (getSettlementMethod()!=null) return true;
			if (getSettlementDate()!=null) return true;
			if (getFinalPrice()!=null) return true;
			if (getRecoveryPercent()!=null) return true;
			if (getPubliclyAvailableInformation()!=null && getPubliclyAvailableInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditChangeEventBase.CreditChangeEventBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CreditChangeEventBase.CreditChangeEventBaseBuilder o = (CreditChangeEventBase.CreditChangeEventBaseBuilder) other;
			
			merger.mergeRosetta(getCreditEventType(), o.getCreditEventType(), this::setCreditEventType);
			merger.mergeRosetta(getPubliclyAvailableInformation(), o.getPubliclyAvailableInformation(), this::getOrCreatePubliclyAvailableInformation);
			
			merger.mergeBasic(getEventDeterminationDate(), o.getEventDeterminationDate(), this::setEventDeterminationDate);
			merger.mergeBasic(getAuctionDate(), o.getAuctionDate(), this::setAuctionDate);
			merger.mergeBasic(getSettlementMethod(), o.getSettlementMethod(), this::setSettlementMethod);
			merger.mergeBasic(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeBasic(getFinalPrice(), o.getFinalPrice(), this::setFinalPrice);
			merger.mergeBasic(getRecoveryPercent(), o.getRecoveryPercent(), this::setRecoveryPercent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditChangeEventBase _that = getType().cast(o);
		
			if (!Objects.equals(creditEventType, _that.getCreditEventType())) return false;
			if (!Objects.equals(eventDeterminationDate, _that.getEventDeterminationDate())) return false;
			if (!Objects.equals(auctionDate, _that.getAuctionDate())) return false;
			if (!Objects.equals(settlementMethod, _that.getSettlementMethod())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(finalPrice, _that.getFinalPrice())) return false;
			if (!Objects.equals(recoveryPercent, _that.getRecoveryPercent())) return false;
			if (!ListEquals.listEquals(publiclyAvailableInformation, _that.getPubliclyAvailableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (creditEventType != null ? creditEventType.hashCode() : 0);
			_result = 31 * _result + (eventDeterminationDate != null ? eventDeterminationDate.hashCode() : 0);
			_result = 31 * _result + (auctionDate != null ? auctionDate.hashCode() : 0);
			_result = 31 * _result + (settlementMethod != null ? settlementMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (finalPrice != null ? finalPrice.hashCode() : 0);
			_result = 31 * _result + (recoveryPercent != null ? recoveryPercent.hashCode() : 0);
			_result = 31 * _result + (publiclyAvailableInformation != null ? publiclyAvailableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditChangeEventBaseBuilder {" +
				"creditEventType=" + this.creditEventType + ", " +
				"eventDeterminationDate=" + this.eventDeterminationDate + ", " +
				"auctionDate=" + this.auctionDate + ", " +
				"settlementMethod=" + this.settlementMethod + ", " +
				"settlementDate=" + this.settlementDate + ", " +
				"finalPrice=" + this.finalPrice + ", " +
				"recoveryPercent=" + this.recoveryPercent + ", " +
				"publiclyAvailableInformation=" + this.publiclyAvailableInformation +
			'}' + " " + super.toString();
		}
	}
}
