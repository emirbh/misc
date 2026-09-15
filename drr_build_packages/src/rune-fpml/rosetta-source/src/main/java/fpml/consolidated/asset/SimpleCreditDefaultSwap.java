package fpml.consolidated.asset;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.asset.meta.SimpleCreditDefaultSwapMeta;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.LegalEntityReference;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.ProductReference;
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
 * Provision Identifies a simple underlying asset that is a credit default swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Identifies a simple underlying asset that is a credit default swap.
 *
 */
@RosettaDataType(value="SimpleCreditDefaultSwap", builder=SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SimpleCreditDefaultSwap", model="fpml", builder=SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilderImpl.class, version="2.1.1")
public interface SimpleCreditDefaultSwap extends UnderlyingAsset {

	SimpleCreditDefaultSwapMeta metaData = new SimpleCreditDefaultSwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The entity for which this is defined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The entity for which this is defined.
	 *
	 */
	LegalEntity getReferenceEntity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An XML reference a credit entity defined elsewhere in the document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An XML reference a credit entity defined elsewhere in the document.
	 *
	 */
	LegalEntityReference getCreditEntityReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the term of the simple CD swap, e.g. 5Y.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the term of the simple CD swap, e.g. 5Y.
	 *
	 */
	Period getTerm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the frequency at which the swap pays, e.g. 6M.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the frequency at which the swap pays, e.g. 6M.
	 *
	 */
	Period getPaymentFrequency();

	/*********************** Build Methods  ***********************/
	SimpleCreditDefaultSwap build();
	
	SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder toBuilder();
	
	static SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder builder() {
		return new SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SimpleCreditDefaultSwap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SimpleCreditDefaultSwap> getType() {
		return SimpleCreditDefaultSwap.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.class, getInstrumentType());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.class, getCurrency());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
		processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.class, getClearanceSystem());
		processRosetta(path.newSubPath("definition"), processor, ProductReference.class, getDefinition());
		processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.class, getReferenceEntity());
		processRosetta(path.newSubPath("creditEntityReference"), processor, LegalEntityReference.class, getCreditEntityReference());
		processRosetta(path.newSubPath("term"), processor, Period.class, getTerm());
		processRosetta(path.newSubPath("paymentFrequency"), processor, Period.class, getPaymentFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SimpleCreditDefaultSwapBuilder extends SimpleCreditDefaultSwap, UnderlyingAsset.UnderlyingAssetBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity();
		@Override
		LegalEntity.LegalEntityBuilder getReferenceEntity();
		LegalEntityReference.LegalEntityReferenceBuilder getOrCreateCreditEntityReference();
		@Override
		LegalEntityReference.LegalEntityReferenceBuilder getCreditEntityReference();
		Period.PeriodBuilder getOrCreateTerm();
		@Override
		Period.PeriodBuilder getTerm();
		Period.PeriodBuilder getOrCreatePaymentFrequency();
		@Override
		Period.PeriodBuilder getPaymentFrequency();
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setId(String id);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setDescription(String description);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setDefinition(ProductReference definition);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setReferenceEntity(LegalEntity referenceEntity);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setCreditEntityReference(LegalEntityReference creditEntityReference);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setTerm(Period term);
		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setPaymentFrequency(Period paymentFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processRosetta(path.newSubPath("instrumentType"), processor, InstrumentType.InstrumentTypeBuilder.class, getInstrumentType());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("currency"), processor, IdentifiedCurrency.IdentifiedCurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("clearanceSystem"), processor, ClearanceSystem.ClearanceSystemBuilder.class, getClearanceSystem());
			processRosetta(path.newSubPath("definition"), processor, ProductReference.ProductReferenceBuilder.class, getDefinition());
			processRosetta(path.newSubPath("referenceEntity"), processor, LegalEntity.LegalEntityBuilder.class, getReferenceEntity());
			processRosetta(path.newSubPath("creditEntityReference"), processor, LegalEntityReference.LegalEntityReferenceBuilder.class, getCreditEntityReference());
			processRosetta(path.newSubPath("term"), processor, Period.PeriodBuilder.class, getTerm());
			processRosetta(path.newSubPath("paymentFrequency"), processor, Period.PeriodBuilder.class, getPaymentFrequency());
		}
		

		SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder prune();
	}

	/*********************** Immutable Implementation of SimpleCreditDefaultSwap  ***********************/
	class SimpleCreditDefaultSwapImpl extends UnderlyingAsset.UnderlyingAssetImpl implements SimpleCreditDefaultSwap {
		private final LegalEntity referenceEntity;
		private final LegalEntityReference creditEntityReference;
		private final Period term;
		private final Period paymentFrequency;
		
		protected SimpleCreditDefaultSwapImpl(SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder builder) {
			super(builder);
			this.referenceEntity = ofNullable(builder.getReferenceEntity()).map(f->f.build()).orElse(null);
			this.creditEntityReference = ofNullable(builder.getCreditEntityReference()).map(f->f.build()).orElse(null);
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.paymentFrequency = ofNullable(builder.getPaymentFrequency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceEntity")
		public LegalEntity getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		@RosettaAttribute("creditEntityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEntityReference")
		public LegalEntityReference getCreditEntityReference() {
			return creditEntityReference;
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public Period getTerm() {
			return term;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Period getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public SimpleCreditDefaultSwap build() {
			return this;
		}
		
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder toBuilder() {
			SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReferenceEntity()).ifPresent(builder::setReferenceEntity);
			ofNullable(getCreditEntityReference()).ifPresent(builder::setCreditEntityReference);
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getPaymentFrequency()).ifPresent(builder::setPaymentFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimpleCreditDefaultSwap _that = getType().cast(o);
		
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(creditEntityReference, _that.getCreditEntityReference())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (creditEntityReference != null ? creditEntityReference.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleCreditDefaultSwap {" +
				"referenceEntity=" + this.referenceEntity + ", " +
				"creditEntityReference=" + this.creditEntityReference + ", " +
				"term=" + this.term + ", " +
				"paymentFrequency=" + this.paymentFrequency +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SimpleCreditDefaultSwap  ***********************/
	class SimpleCreditDefaultSwapBuilderImpl extends UnderlyingAsset.UnderlyingAssetBuilderImpl implements SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder {
	
		protected LegalEntity.LegalEntityBuilder referenceEntity;
		protected LegalEntityReference.LegalEntityReferenceBuilder creditEntityReference;
		protected Period.PeriodBuilder term;
		protected Period.PeriodBuilder paymentFrequency;
		
		@Override
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceEntity")
		public LegalEntity.LegalEntityBuilder getReferenceEntity() {
			return referenceEntity;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateReferenceEntity() {
			LegalEntity.LegalEntityBuilder result;
			if (referenceEntity!=null) {
				result = referenceEntity;
			}
			else {
				result = referenceEntity = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditEntityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditEntityReference")
		public LegalEntityReference.LegalEntityReferenceBuilder getCreditEntityReference() {
			return creditEntityReference;
		}
		
		@Override
		public LegalEntityReference.LegalEntityReferenceBuilder getOrCreateCreditEntityReference() {
			LegalEntityReference.LegalEntityReferenceBuilder result;
			if (creditEntityReference!=null) {
				result = creditEntityReference;
			}
			else {
				result = creditEntityReference = LegalEntityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public Period.PeriodBuilder getTerm() {
			return term;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateTerm() {
			Period.PeriodBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentFrequency")
		public Period.PeriodBuilder getPaymentFrequency() {
			return paymentFrequency;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreatePaymentFrequency() {
			Period.PeriodBuilder result;
			if (paymentFrequency!=null) {
				result = paymentFrequency;
			}
			else {
				result = paymentFrequency = Period.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes != null) {
				for (final InstrumentType toAdd : instrumentTypes) {
					this.instrumentType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("instrumentType")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
			if (instrumentTypes == null) {
				this.instrumentType = new ArrayList<>();
			} else {
				this.instrumentType = instrumentTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceEntity")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setReferenceEntity(LegalEntity _referenceEntity) {
			this.referenceEntity = _referenceEntity == null ? null : _referenceEntity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditEntityReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditEntityReference")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setCreditEntityReference(LegalEntityReference _creditEntityReference) {
			this.creditEntityReference = _creditEntityReference == null ? null : _creditEntityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("term")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("term")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setTerm(Period _term) {
			this.term = _term == null ? null : _term.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentFrequency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentFrequency")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder setPaymentFrequency(Period _paymentFrequency) {
			this.paymentFrequency = _paymentFrequency == null ? null : _paymentFrequency.toBuilder();
			return this;
		}
		
		@Override
		public SimpleCreditDefaultSwap build() {
			return new SimpleCreditDefaultSwap.SimpleCreditDefaultSwapImpl(this);
		}
		
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder prune() {
			super.prune();
			if (referenceEntity!=null && !referenceEntity.prune().hasData()) referenceEntity = null;
			if (creditEntityReference!=null && !creditEntityReference.prune().hasData()) creditEntityReference = null;
			if (term!=null && !term.prune().hasData()) term = null;
			if (paymentFrequency!=null && !paymentFrequency.prune().hasData()) paymentFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReferenceEntity()!=null && getReferenceEntity().hasData()) return true;
			if (getCreditEntityReference()!=null && getCreditEntityReference().hasData()) return true;
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getPaymentFrequency()!=null && getPaymentFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder o = (SimpleCreditDefaultSwap.SimpleCreditDefaultSwapBuilder) other;
			
			merger.mergeRosetta(getReferenceEntity(), o.getReferenceEntity(), this::setReferenceEntity);
			merger.mergeRosetta(getCreditEntityReference(), o.getCreditEntityReference(), this::setCreditEntityReference);
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			merger.mergeRosetta(getPaymentFrequency(), o.getPaymentFrequency(), this::setPaymentFrequency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimpleCreditDefaultSwap _that = getType().cast(o);
		
			if (!Objects.equals(referenceEntity, _that.getReferenceEntity())) return false;
			if (!Objects.equals(creditEntityReference, _that.getCreditEntityReference())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(paymentFrequency, _that.getPaymentFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (referenceEntity != null ? referenceEntity.hashCode() : 0);
			_result = 31 * _result + (creditEntityReference != null ? creditEntityReference.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleCreditDefaultSwapBuilder {" +
				"referenceEntity=" + this.referenceEntity + ", " +
				"creditEntityReference=" + this.creditEntityReference + ", " +
				"term=" + this.term + ", " +
				"paymentFrequency=" + this.paymentFrequency +
			'}' + " " + super.toString();
		}
	}
}
