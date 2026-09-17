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
import fpml.consolidated.asset.meta.WarrantMeta;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Defines the underlying asset when it is a warrant.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines the underlying asset when it is a warrant.
 *
 */
@RosettaDataType(value="Warrant", builder=Warrant.WarrantBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Warrant", model="fpml", builder=Warrant.WarrantBuilderImpl.class, version="2.1.1")
public interface Warrant extends ExchangeTradedContract {

	WarrantMeta metaData = new WarrantMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	Warrant build();
	
	Warrant.WarrantBuilder toBuilder();
	
	static Warrant.WarrantBuilder builder() {
		return new Warrant.WarrantBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Warrant> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Warrant> getType() {
		return Warrant.class;
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
		processRosetta(path.newSubPath("relatedExchangeId"), processor, ExchangeId.class, getRelatedExchangeId());
		processRosetta(path.newSubPath("optionsExchangeId"), processor, ExchangeId.class, getOptionsExchangeId());
		processRosetta(path.newSubPath("specifiedExchangeId"), processor, ExchangeId.class, getSpecifiedExchangeId());
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		processor.processBasic(path.newSubPath("contractReference"), String.class, getContractReference(), this);
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WarrantBuilder extends Warrant, ExchangeTradedContract.ExchangeTradedContractBuilder {
		@Override
		Warrant.WarrantBuilder setId(String id);
		@Override
		Warrant.WarrantBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		Warrant.WarrantBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		Warrant.WarrantBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Warrant.WarrantBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Warrant.WarrantBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		Warrant.WarrantBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		Warrant.WarrantBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Warrant.WarrantBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		Warrant.WarrantBuilder setDescription(String description);
		@Override
		Warrant.WarrantBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		Warrant.WarrantBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		Warrant.WarrantBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		Warrant.WarrantBuilder setDefinition(ProductReference definition);
		@Override
		Warrant.WarrantBuilder addRelatedExchangeId(ExchangeId relatedExchangeId);
		@Override
		Warrant.WarrantBuilder addRelatedExchangeId(ExchangeId relatedExchangeId, int idx);
		@Override
		Warrant.WarrantBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		Warrant.WarrantBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		Warrant.WarrantBuilder addOptionsExchangeId(ExchangeId optionsExchangeId);
		@Override
		Warrant.WarrantBuilder addOptionsExchangeId(ExchangeId optionsExchangeId, int idx);
		@Override
		Warrant.WarrantBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		Warrant.WarrantBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		Warrant.WarrantBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId);
		@Override
		Warrant.WarrantBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId, int idx);
		@Override
		Warrant.WarrantBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		@Override
		Warrant.WarrantBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		@Override
		Warrant.WarrantBuilder setMultiplier(BigDecimal multiplier);
		@Override
		Warrant.WarrantBuilder setContractReference(String contractReference);
		@Override
		Warrant.WarrantBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);

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
			processRosetta(path.newSubPath("relatedExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getRelatedExchangeId());
			processRosetta(path.newSubPath("optionsExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getOptionsExchangeId());
			processRosetta(path.newSubPath("specifiedExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getSpecifiedExchangeId());
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
			processor.processBasic(path.newSubPath("contractReference"), String.class, getContractReference(), this);
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
		}
		

		Warrant.WarrantBuilder prune();
	}

	/*********************** Immutable Implementation of Warrant  ***********************/
	class WarrantImpl extends ExchangeTradedContract.ExchangeTradedContractImpl implements Warrant {
		
		protected WarrantImpl(Warrant.WarrantBuilder builder) {
			super(builder);
		}
		
		@Override
		public Warrant build() {
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder toBuilder() {
			Warrant.WarrantBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Warrant.WarrantBuilder builder) {
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
			return "Warrant {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Warrant  ***********************/
	class WarrantBuilderImpl extends ExchangeTradedContract.ExchangeTradedContractBuilderImpl implements Warrant.WarrantBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Warrant.WarrantBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Warrant.WarrantBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Warrant.WarrantBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Warrant.WarrantBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public Warrant.WarrantBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public Warrant.WarrantBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public Warrant.WarrantBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public Warrant.WarrantBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public Warrant.WarrantBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public Warrant.WarrantBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public Warrant.WarrantBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId) {
			if (_relatedExchangeId != null) {
				this.relatedExchangeId.add(_relatedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId, int idx) {
			getIndex(this.relatedExchangeId, idx, () -> _relatedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
			if (relatedExchangeIds != null) {
				for (final ExchangeId toAdd : relatedExchangeIds) {
					this.relatedExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public Warrant.WarrantBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
			if (relatedExchangeIds == null) {
				this.relatedExchangeId = new ArrayList<>();
			} else {
				this.relatedExchangeId = relatedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		@Override
		public Warrant.WarrantBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId) {
			if (_optionsExchangeId != null) {
				this.optionsExchangeId.add(_optionsExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId, int idx) {
			getIndex(this.optionsExchangeId, idx, () -> _optionsExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
			if (optionsExchangeIds != null) {
				for (final ExchangeId toAdd : optionsExchangeIds) {
					this.optionsExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("optionsExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("optionsExchangeId")
		@Override
		public Warrant.WarrantBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
			if (optionsExchangeIds == null) {
				this.optionsExchangeId = new ArrayList<>();
			} else {
				this.optionsExchangeId = optionsExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		@Override
		public Warrant.WarrantBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId) {
			if (_specifiedExchangeId != null) {
				this.specifiedExchangeId.add(_specifiedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId, int idx) {
			getIndex(this.specifiedExchangeId, idx, () -> _specifiedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public Warrant.WarrantBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds != null) {
				for (final ExchangeId toAdd : specifiedExchangeIds) {
					this.specifiedExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("specifiedExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("specifiedExchangeId")
		@Override
		public Warrant.WarrantBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds == null) {
				this.specifiedExchangeId = new ArrayList<>();
			} else {
				this.specifiedExchangeId = specifiedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiplier")
		@Override
		public Warrant.WarrantBuilder setMultiplier(BigDecimal _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier;
			return this;
		}
		
		@RosettaAttribute("contractReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractReference")
		@Override
		public Warrant.WarrantBuilder setContractReference(String _contractReference) {
			this.contractReference = _contractReference == null ? null : _contractReference;
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public Warrant.WarrantBuilder setExpirationDate(AdjustableOrRelativeDate _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate.toBuilder();
			return this;
		}
		
		@Override
		public Warrant build() {
			return new Warrant.WarrantImpl(this);
		}
		
		@Override
		public Warrant.WarrantBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Warrant.WarrantBuilder prune() {
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
		public Warrant.WarrantBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Warrant.WarrantBuilder o = (Warrant.WarrantBuilder) other;
			
			
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
			return "WarrantBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
