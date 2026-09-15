package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.CreditChangeEventMeta;
import fpml.consolidated.cd.CreditEventIndexReferenceInformation;
import fpml.consolidated.cd.ReferenceInformation;
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
 * Provision A structure indicating that a trade has changed due to a credit event, including both shared (by single name, index and basket) and index specific components.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure indicating that a trade has changed due to a credit event, including both shared (by single name, index and basket) and index specific components.
 *
 */
@RosettaDataType(value="CreditChangeEvent", builder=CreditChangeEvent.CreditChangeEventBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditChangeEvent", model="fpml", builder=CreditChangeEvent.CreditChangeEventBuilderImpl.class, version="2.1.1")
public interface CreditChangeEvent extends CreditChangeEventBase {

	CreditChangeEventMeta metaData = new CreditChangeEventMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A type defining the Credit Default Swap Index impacted by the credit event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A type defining the Credit Default Swap Index impacted by the credit event.
	 *
	 */
	CreditEventIndexReferenceInformation getIndexReferenceInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The corporate or sovereign entity (and, optionally, associated obligations) in a basket impacted by the credit event.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The corporate or sovereign entity (and, optionally, associated obligations) in a basket impacted by the credit event.
	 *
	 */
	ReferenceInformation getExcludedReferenceEntity();

	/*********************** Build Methods  ***********************/
	CreditChangeEvent build();
	
	CreditChangeEvent.CreditChangeEventBuilder toBuilder();
	
	static CreditChangeEvent.CreditChangeEventBuilder builder() {
		return new CreditChangeEvent.CreditChangeEventBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditChangeEvent> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditChangeEvent> getType() {
		return CreditChangeEvent.class;
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
		processRosetta(path.newSubPath("indexReferenceInformation"), processor, CreditEventIndexReferenceInformation.class, getIndexReferenceInformation());
		processRosetta(path.newSubPath("excludedReferenceEntity"), processor, ReferenceInformation.class, getExcludedReferenceEntity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditChangeEventBuilder extends CreditChangeEvent, CreditChangeEventBase.CreditChangeEventBaseBuilder {
		CreditEventIndexReferenceInformation.CreditEventIndexReferenceInformationBuilder getOrCreateIndexReferenceInformation();
		@Override
		CreditEventIndexReferenceInformation.CreditEventIndexReferenceInformationBuilder getIndexReferenceInformation();
		ReferenceInformation.ReferenceInformationBuilder getOrCreateExcludedReferenceEntity();
		@Override
		ReferenceInformation.ReferenceInformationBuilder getExcludedReferenceEntity();
		@Override
		CreditChangeEvent.CreditChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder setCreditEventType(CreditEventType creditEventType);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder setEventDeterminationDate(ZonedDateTime eventDeterminationDate);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder setAuctionDate(ZonedDateTime auctionDate);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder setSettlementMethod(CashOrPhysicalSettlementEnum settlementMethod);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder setSettlementDate(ZonedDateTime settlementDate);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder setFinalPrice(BigDecimal finalPrice);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder setRecoveryPercent(BigDecimal recoveryPercent);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder addPubliclyAvailableInformation(Resource publiclyAvailableInformation, int idx);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation);
		@Override
		CreditChangeEvent.CreditChangeEventBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformation);
		CreditChangeEvent.CreditChangeEventBuilder setIndexReferenceInformation(CreditEventIndexReferenceInformation indexReferenceInformation);
		CreditChangeEvent.CreditChangeEventBuilder setExcludedReferenceEntity(ReferenceInformation excludedReferenceEntity);

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
			processRosetta(path.newSubPath("indexReferenceInformation"), processor, CreditEventIndexReferenceInformation.CreditEventIndexReferenceInformationBuilder.class, getIndexReferenceInformation());
			processRosetta(path.newSubPath("excludedReferenceEntity"), processor, ReferenceInformation.ReferenceInformationBuilder.class, getExcludedReferenceEntity());
		}
		

		CreditChangeEvent.CreditChangeEventBuilder prune();
	}

	/*********************** Immutable Implementation of CreditChangeEvent  ***********************/
	class CreditChangeEventImpl extends CreditChangeEventBase.CreditChangeEventBaseImpl implements CreditChangeEvent {
		private final CreditEventIndexReferenceInformation indexReferenceInformation;
		private final ReferenceInformation excludedReferenceEntity;
		
		protected CreditChangeEventImpl(CreditChangeEvent.CreditChangeEventBuilder builder) {
			super(builder);
			this.indexReferenceInformation = ofNullable(builder.getIndexReferenceInformation()).map(f->f.build()).orElse(null);
			this.excludedReferenceEntity = ofNullable(builder.getExcludedReferenceEntity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexReferenceInformation")
		public CreditEventIndexReferenceInformation getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		@RosettaAttribute("excludedReferenceEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excludedReferenceEntity")
		public ReferenceInformation getExcludedReferenceEntity() {
			return excludedReferenceEntity;
		}
		
		@Override
		public CreditChangeEvent build() {
			return this;
		}
		
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder toBuilder() {
			CreditChangeEvent.CreditChangeEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditChangeEvent.CreditChangeEventBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIndexReferenceInformation()).ifPresent(builder::setIndexReferenceInformation);
			ofNullable(getExcludedReferenceEntity()).ifPresent(builder::setExcludedReferenceEntity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditChangeEvent _that = getType().cast(o);
		
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(excludedReferenceEntity, _that.getExcludedReferenceEntity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (excludedReferenceEntity != null ? excludedReferenceEntity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditChangeEvent {" +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"excludedReferenceEntity=" + this.excludedReferenceEntity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CreditChangeEvent  ***********************/
	class CreditChangeEventBuilderImpl extends CreditChangeEventBase.CreditChangeEventBaseBuilderImpl implements CreditChangeEvent.CreditChangeEventBuilder {
	
		protected CreditEventIndexReferenceInformation.CreditEventIndexReferenceInformationBuilder indexReferenceInformation;
		protected ReferenceInformation.ReferenceInformationBuilder excludedReferenceEntity;
		
		@Override
		@RosettaAttribute("indexReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexReferenceInformation")
		public CreditEventIndexReferenceInformation.CreditEventIndexReferenceInformationBuilder getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		public CreditEventIndexReferenceInformation.CreditEventIndexReferenceInformationBuilder getOrCreateIndexReferenceInformation() {
			CreditEventIndexReferenceInformation.CreditEventIndexReferenceInformationBuilder result;
			if (indexReferenceInformation!=null) {
				result = indexReferenceInformation;
			}
			else {
				result = indexReferenceInformation = CreditEventIndexReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("excludedReferenceEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("excludedReferenceEntity")
		public ReferenceInformation.ReferenceInformationBuilder getExcludedReferenceEntity() {
			return excludedReferenceEntity;
		}
		
		@Override
		public ReferenceInformation.ReferenceInformationBuilder getOrCreateExcludedReferenceEntity() {
			ReferenceInformation.ReferenceInformationBuilder result;
			if (excludedReferenceEntity!=null) {
				result = excludedReferenceEntity;
			}
			else {
				result = excludedReferenceEntity = ReferenceInformation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public CreditChangeEvent.CreditChangeEventBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
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
		public CreditChangeEvent.CreditChangeEventBuilder setCreditEventType(CreditEventType _creditEventType) {
			this.creditEventType = _creditEventType == null ? null : _creditEventType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventDeterminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("eventDeterminationDate")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder setEventDeterminationDate(ZonedDateTime _eventDeterminationDate) {
			this.eventDeterminationDate = _eventDeterminationDate == null ? null : _eventDeterminationDate;
			return this;
		}
		
		@RosettaAttribute("auctionDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("auctionDate")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder setAuctionDate(ZonedDateTime _auctionDate) {
			this.auctionDate = _auctionDate == null ? null : _auctionDate;
			return this;
		}
		
		@RosettaAttribute("settlementMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementMethod")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder setSettlementMethod(CashOrPhysicalSettlementEnum _settlementMethod) {
			this.settlementMethod = _settlementMethod == null ? null : _settlementMethod;
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder setSettlementDate(ZonedDateTime _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate;
			return this;
		}
		
		@RosettaAttribute("finalPrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("finalPrice")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder setFinalPrice(BigDecimal _finalPrice) {
			this.finalPrice = _finalPrice == null ? null : _finalPrice;
			return this;
		}
		
		@RosettaAttribute("recoveryPercent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("recoveryPercent")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder setRecoveryPercent(BigDecimal _recoveryPercent) {
			this.recoveryPercent = _recoveryPercent == null ? null : _recoveryPercent;
			return this;
		}
		
		@RosettaAttribute("publiclyAvailableInformation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("publiclyAvailableInformation")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder addPubliclyAvailableInformation(Resource _publiclyAvailableInformation) {
			if (_publiclyAvailableInformation != null) {
				this.publiclyAvailableInformation.add(_publiclyAvailableInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder addPubliclyAvailableInformation(Resource _publiclyAvailableInformation, int idx) {
			getIndex(this.publiclyAvailableInformation, idx, () -> _publiclyAvailableInformation.toBuilder());
			return this;
		}
		
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder addPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
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
		public CreditChangeEvent.CreditChangeEventBuilder setPubliclyAvailableInformation(List<? extends Resource> publiclyAvailableInformations) {
			if (publiclyAvailableInformations == null) {
				this.publiclyAvailableInformation = new ArrayList<>();
			} else {
				this.publiclyAvailableInformation = publiclyAvailableInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("indexReferenceInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexReferenceInformation")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder setIndexReferenceInformation(CreditEventIndexReferenceInformation _indexReferenceInformation) {
			this.indexReferenceInformation = _indexReferenceInformation == null ? null : _indexReferenceInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("excludedReferenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("excludedReferenceEntity")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder setExcludedReferenceEntity(ReferenceInformation _excludedReferenceEntity) {
			this.excludedReferenceEntity = _excludedReferenceEntity == null ? null : _excludedReferenceEntity.toBuilder();
			return this;
		}
		
		@Override
		public CreditChangeEvent build() {
			return new CreditChangeEvent.CreditChangeEventImpl(this);
		}
		
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder prune() {
			super.prune();
			if (indexReferenceInformation!=null && !indexReferenceInformation.prune().hasData()) indexReferenceInformation = null;
			if (excludedReferenceEntity!=null && !excludedReferenceEntity.prune().hasData()) excludedReferenceEntity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIndexReferenceInformation()!=null && getIndexReferenceInformation().hasData()) return true;
			if (getExcludedReferenceEntity()!=null && getExcludedReferenceEntity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditChangeEvent.CreditChangeEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CreditChangeEvent.CreditChangeEventBuilder o = (CreditChangeEvent.CreditChangeEventBuilder) other;
			
			merger.mergeRosetta(getIndexReferenceInformation(), o.getIndexReferenceInformation(), this::setIndexReferenceInformation);
			merger.mergeRosetta(getExcludedReferenceEntity(), o.getExcludedReferenceEntity(), this::setExcludedReferenceEntity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditChangeEvent _that = getType().cast(o);
		
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(excludedReferenceEntity, _that.getExcludedReferenceEntity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (excludedReferenceEntity != null ? excludedReferenceEntity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditChangeEventBuilder {" +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"excludedReferenceEntity=" + this.excludedReferenceEntity +
			'}' + " " + super.toString();
		}
	}
}
