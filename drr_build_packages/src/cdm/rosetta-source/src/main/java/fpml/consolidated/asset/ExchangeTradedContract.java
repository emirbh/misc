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
import fpml.consolidated.asset.meta.ExchangeTradedContractMeta;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.ProductReference;
import java.math.BigDecimal;
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
 * Provision An exchange traded derivative contract.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An exchange traded derivative contract.
 *
 */
@RosettaDataType(value="ExchangeTradedContract", builder=ExchangeTradedContract.ExchangeTradedContractBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExchangeTradedContract", model="fpml", builder=ExchangeTradedContract.ExchangeTradedContractBuilderImpl.class, version="2.1.1")
public interface ExchangeTradedContract extends ExchangeTraded {

	ExchangeTradedContractMeta metaData = new ExchangeTradedContractMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the contract multiplier that can be associated with the number of units.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the contract multiplier that can be associated with the number of units.
	 *
	 */
	BigDecimal getMultiplier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the contract that can be referenced, besides the undelyer type.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the contract that can be referenced, besides the undelyer type.
	 *
	 */
	String getContractReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date when the contract expires.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date when the contract expires.
	 *
	 */
	AdjustableOrRelativeDate getExpirationDate();

	/*********************** Build Methods  ***********************/
	ExchangeTradedContract build();
	
	ExchangeTradedContract.ExchangeTradedContractBuilder toBuilder();
	
	static ExchangeTradedContract.ExchangeTradedContractBuilder builder() {
		return new ExchangeTradedContract.ExchangeTradedContractBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTradedContract> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExchangeTradedContract> getType() {
		return ExchangeTradedContract.class;
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
	interface ExchangeTradedContractBuilder extends ExchangeTradedContract, ExchangeTraded.ExchangeTradedBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder setId(String id);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder setDescription(String description);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder setDefinition(ProductReference definition);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addRelatedExchangeId(ExchangeId relatedExchangeId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addRelatedExchangeId(ExchangeId relatedExchangeId, int idx);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addOptionsExchangeId(ExchangeId optionsExchangeId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addOptionsExchangeId(ExchangeId optionsExchangeId, int idx);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId, int idx);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		@Override
		ExchangeTradedContract.ExchangeTradedContractBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		ExchangeTradedContract.ExchangeTradedContractBuilder setMultiplier(BigDecimal multiplier);
		ExchangeTradedContract.ExchangeTradedContractBuilder setContractReference(String contractReference);
		ExchangeTradedContract.ExchangeTradedContractBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);

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
		

		ExchangeTradedContract.ExchangeTradedContractBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTradedContract  ***********************/
	class ExchangeTradedContractImpl extends ExchangeTraded.ExchangeTradedImpl implements ExchangeTradedContract {
		private final BigDecimal multiplier;
		private final String contractReference;
		private final AdjustableOrRelativeDate expirationDate;
		
		protected ExchangeTradedContractImpl(ExchangeTradedContract.ExchangeTradedContractBuilder builder) {
			super(builder);
			this.multiplier = builder.getMultiplier();
			this.contractReference = builder.getContractReference();
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("contractReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractReference")
		public String getContractReference() {
			return contractReference;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDate")
		public AdjustableOrRelativeDate getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public ExchangeTradedContract build() {
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder toBuilder() {
			ExchangeTradedContract.ExchangeTradedContractBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTradedContract.ExchangeTradedContractBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
			ofNullable(getContractReference()).ifPresent(builder::setContractReference);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedContract _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(contractReference, _that.getContractReference())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (contractReference != null ? contractReference.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedContract {" +
				"multiplier=" + this.multiplier + ", " +
				"contractReference=" + this.contractReference + ", " +
				"expirationDate=" + this.expirationDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExchangeTradedContract  ***********************/
	class ExchangeTradedContractBuilderImpl extends ExchangeTraded.ExchangeTradedBuilderImpl implements ExchangeTradedContract.ExchangeTradedContractBuilder {
	
		protected BigDecimal multiplier;
		protected String contractReference;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
		
		@Override
		@RosettaAttribute("multiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("contractReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractReference")
		public String getContractReference() {
			return contractReference;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expirationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (expirationDate!=null) {
				result = expirationDate;
			}
			else {
				result = expirationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTradedContract.ExchangeTradedContractBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public ExchangeTradedContract.ExchangeTradedContractBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public ExchangeTradedContract.ExchangeTradedContractBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId) {
			if (_relatedExchangeId != null) {
				this.relatedExchangeId.add(_relatedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId, int idx) {
			getIndex(this.relatedExchangeId, idx, () -> _relatedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
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
		public ExchangeTradedContract.ExchangeTradedContractBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
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
		public ExchangeTradedContract.ExchangeTradedContractBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId) {
			if (_optionsExchangeId != null) {
				this.optionsExchangeId.add(_optionsExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId, int idx) {
			getIndex(this.optionsExchangeId, idx, () -> _optionsExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
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
		public ExchangeTradedContract.ExchangeTradedContractBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
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
		public ExchangeTradedContract.ExchangeTradedContractBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId) {
			if (_specifiedExchangeId != null) {
				this.specifiedExchangeId.add(_specifiedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId, int idx) {
			getIndex(this.specifiedExchangeId, idx, () -> _specifiedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
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
		public ExchangeTradedContract.ExchangeTradedContractBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
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
		public ExchangeTradedContract.ExchangeTradedContractBuilder setMultiplier(BigDecimal _multiplier) {
			this.multiplier = _multiplier == null ? null : _multiplier;
			return this;
		}
		
		@RosettaAttribute("contractReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractReference")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder setContractReference(String _contractReference) {
			this.contractReference = _contractReference == null ? null : _contractReference;
			return this;
		}
		
		@RosettaAttribute("expirationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expirationDate")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder setExpirationDate(AdjustableOrRelativeDate _expirationDate) {
			this.expirationDate = _expirationDate == null ? null : _expirationDate.toBuilder();
			return this;
		}
		
		@Override
		public ExchangeTradedContract build() {
			return new ExchangeTradedContract.ExchangeTradedContractImpl(this);
		}
		
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder prune() {
			super.prune();
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMultiplier()!=null) return true;
			if (getContractReference()!=null) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedContract.ExchangeTradedContractBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ExchangeTradedContract.ExchangeTradedContractBuilder o = (ExchangeTradedContract.ExchangeTradedContractBuilder) other;
			
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			merger.mergeBasic(getContractReference(), o.getContractReference(), this::setContractReference);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedContract _that = getType().cast(o);
		
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			if (!Objects.equals(contractReference, _that.getContractReference())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			_result = 31 * _result + (contractReference != null ? contractReference.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedContractBuilder {" +
				"multiplier=" + this.multiplier + ", " +
				"contractReference=" + this.contractReference + ", " +
				"expirationDate=" + this.expirationDate +
			'}' + " " + super.toString();
		}
	}
}
