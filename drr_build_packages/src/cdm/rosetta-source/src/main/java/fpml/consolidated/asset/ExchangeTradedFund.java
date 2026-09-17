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
import fpml.consolidated.asset.meta.ExchangeTradedFundMeta;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
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
 * Provision An exchange traded fund whose price depends on exchange traded constituents.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An exchange traded fund whose price depends on exchange traded constituents.
 *
 */
@RosettaDataType(value="ExchangeTradedFund", builder=ExchangeTradedFund.ExchangeTradedFundBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExchangeTradedFund", model="fpml", builder=ExchangeTradedFund.ExchangeTradedFundBuilderImpl.class, version="2.1.1")
public interface ExchangeTradedFund extends ExchangeTradedCalculatedPrice {

	ExchangeTradedFundMeta metaData = new ExchangeTradedFundMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fund manager that is in charge of the fund.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fund manager that is in charge of the fund.
	 *
	 */
	String getFundManager();

	/*********************** Build Methods  ***********************/
	ExchangeTradedFund build();
	
	ExchangeTradedFund.ExchangeTradedFundBuilder toBuilder();
	
	static ExchangeTradedFund.ExchangeTradedFundBuilder builder() {
		return new ExchangeTradedFund.ExchangeTradedFundBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExchangeTradedFund> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExchangeTradedFund> getType() {
		return ExchangeTradedFund.class;
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
		processRosetta(path.newSubPath("constituentExchangeId"), processor, ExchangeId.class, getConstituentExchangeId());
		processor.processBasic(path.newSubPath("fundManager"), String.class, getFundManager(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExchangeTradedFundBuilder extends ExchangeTradedFund, ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilder {
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setId(String id);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setDescription(String description);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setDefinition(ProductReference definition);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addRelatedExchangeId(ExchangeId relatedExchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addRelatedExchangeId(ExchangeId relatedExchangeId, int idx);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addOptionsExchangeId(ExchangeId optionsExchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addOptionsExchangeId(ExchangeId optionsExchangeId, int idx);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addSpecifiedExchangeId(ExchangeId specifiedExchangeId, int idx);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(ExchangeId constituentExchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(ExchangeId constituentExchangeId, int idx);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId);
		@Override
		ExchangeTradedFund.ExchangeTradedFundBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeId);
		ExchangeTradedFund.ExchangeTradedFundBuilder setFundManager(String fundManager);

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
			processRosetta(path.newSubPath("constituentExchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getConstituentExchangeId());
			processor.processBasic(path.newSubPath("fundManager"), String.class, getFundManager(), this);
		}
		

		ExchangeTradedFund.ExchangeTradedFundBuilder prune();
	}

	/*********************** Immutable Implementation of ExchangeTradedFund  ***********************/
	class ExchangeTradedFundImpl extends ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceImpl implements ExchangeTradedFund {
		private final String fundManager;
		
		protected ExchangeTradedFundImpl(ExchangeTradedFund.ExchangeTradedFundBuilder builder) {
			super(builder);
			this.fundManager = builder.getFundManager();
		}
		
		@Override
		@RosettaAttribute("fundManager")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fundManager")
		public String getFundManager() {
			return fundManager;
		}
		
		@Override
		public ExchangeTradedFund build() {
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder toBuilder() {
			ExchangeTradedFund.ExchangeTradedFundBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExchangeTradedFund.ExchangeTradedFundBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFundManager()).ifPresent(builder::setFundManager);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedFund _that = getType().cast(o);
		
			if (!Objects.equals(fundManager, _that.getFundManager())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fundManager != null ? fundManager.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedFund {" +
				"fundManager=" + this.fundManager +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ExchangeTradedFund  ***********************/
	class ExchangeTradedFundBuilderImpl extends ExchangeTradedCalculatedPrice.ExchangeTradedCalculatedPriceBuilderImpl implements ExchangeTradedFund.ExchangeTradedFundBuilder {
	
		protected String fundManager;
		
		@Override
		@RosettaAttribute("fundManager")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fundManager")
		public String getFundManager() {
			return fundManager;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTradedFund.ExchangeTradedFundBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public ExchangeTradedFund.ExchangeTradedFundBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public ExchangeTradedFund.ExchangeTradedFundBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedExchangeId")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId) {
			if (_relatedExchangeId != null) {
				this.relatedExchangeId.add(_relatedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addRelatedExchangeId(ExchangeId _relatedExchangeId, int idx) {
			getIndex(this.relatedExchangeId, idx, () -> _relatedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
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
		public ExchangeTradedFund.ExchangeTradedFundBuilder setRelatedExchangeId(List<? extends ExchangeId> relatedExchangeIds) {
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
		public ExchangeTradedFund.ExchangeTradedFundBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId) {
			if (_optionsExchangeId != null) {
				this.optionsExchangeId.add(_optionsExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addOptionsExchangeId(ExchangeId _optionsExchangeId, int idx) {
			getIndex(this.optionsExchangeId, idx, () -> _optionsExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
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
		public ExchangeTradedFund.ExchangeTradedFundBuilder setOptionsExchangeId(List<? extends ExchangeId> optionsExchangeIds) {
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
		public ExchangeTradedFund.ExchangeTradedFundBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId) {
			if (_specifiedExchangeId != null) {
				this.specifiedExchangeId.add(_specifiedExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addSpecifiedExchangeId(ExchangeId _specifiedExchangeId, int idx) {
			getIndex(this.specifiedExchangeId, idx, () -> _specifiedExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
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
		public ExchangeTradedFund.ExchangeTradedFundBuilder setSpecifiedExchangeId(List<? extends ExchangeId> specifiedExchangeIds) {
			if (specifiedExchangeIds == null) {
				this.specifiedExchangeId = new ArrayList<>();
			} else {
				this.specifiedExchangeId = specifiedExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("constituentExchangeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("constituentExchangeId")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(ExchangeId _constituentExchangeId) {
			if (_constituentExchangeId != null) {
				this.constituentExchangeId.add(_constituentExchangeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(ExchangeId _constituentExchangeId, int idx) {
			getIndex(this.constituentExchangeId, idx, () -> _constituentExchangeId.toBuilder());
			return this;
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder addConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
			if (constituentExchangeIds != null) {
				for (final ExchangeId toAdd : constituentExchangeIds) {
					this.constituentExchangeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("constituentExchangeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("constituentExchangeId")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder setConstituentExchangeId(List<? extends ExchangeId> constituentExchangeIds) {
			if (constituentExchangeIds == null) {
				this.constituentExchangeId = new ArrayList<>();
			} else {
				this.constituentExchangeId = constituentExchangeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fundManager")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fundManager")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder setFundManager(String _fundManager) {
			this.fundManager = _fundManager == null ? null : _fundManager;
			return this;
		}
		
		@Override
		public ExchangeTradedFund build() {
			return new ExchangeTradedFund.ExchangeTradedFundImpl(this);
		}
		
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFundManager()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExchangeTradedFund.ExchangeTradedFundBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ExchangeTradedFund.ExchangeTradedFundBuilder o = (ExchangeTradedFund.ExchangeTradedFundBuilder) other;
			
			
			merger.mergeBasic(getFundManager(), o.getFundManager(), this::setFundManager);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ExchangeTradedFund _that = getType().cast(o);
		
			if (!Objects.equals(fundManager, _that.getFundManager())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fundManager != null ? fundManager.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExchangeTradedFundBuilder {" +
				"fundManager=" + this.fundManager +
			'}' + " " + super.toString();
		}
	}
}
