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
import fpml.consolidated.asset.meta.SimpleFraMeta;
import fpml.consolidated.shared.ClearanceSystem;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.InstrumentId;
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
 * Provision Identifies a simple underlying asset that is a forward rate agreement.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Identifies a simple underlying asset that is a forward rate agreement.
 *
 */
@RosettaDataType(value="SimpleFra", builder=SimpleFra.SimpleFraBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SimpleFra", model="fpml", builder=SimpleFra.SimpleFraBuilderImpl.class, version="2.1.1")
public interface SimpleFra extends UnderlyingAsset {

	SimpleFraMeta metaData = new SimpleFraMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the start term of the simple fra, e.g. 3M.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the start term of the simple fra, e.g. 3M.
	 *
	 */
	Period getStartTerm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the end term of the simple fra, e.g. 9M.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the end term of the simple fra, e.g. 9M.
	 *
	 */
	Period getEndTerm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The day count basis for the FRA.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The day count basis for the FRA.
	 *
	 */
	DayCountFraction getDayCountFraction();

	/*********************** Build Methods  ***********************/
	SimpleFra build();
	
	SimpleFra.SimpleFraBuilder toBuilder();
	
	static SimpleFra.SimpleFraBuilder builder() {
		return new SimpleFra.SimpleFraBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SimpleFra> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SimpleFra> getType() {
		return SimpleFra.class;
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
		processRosetta(path.newSubPath("startTerm"), processor, Period.class, getStartTerm());
		processRosetta(path.newSubPath("endTerm"), processor, Period.class, getEndTerm());
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SimpleFraBuilder extends SimpleFra, UnderlyingAsset.UnderlyingAssetBuilder {
		Period.PeriodBuilder getOrCreateStartTerm();
		@Override
		Period.PeriodBuilder getStartTerm();
		Period.PeriodBuilder getOrCreateEndTerm();
		@Override
		Period.PeriodBuilder getEndTerm();
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		@Override
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		@Override
		SimpleFra.SimpleFraBuilder setId(String id);
		@Override
		SimpleFra.SimpleFraBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		SimpleFra.SimpleFraBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		SimpleFra.SimpleFraBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		SimpleFra.SimpleFraBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		SimpleFra.SimpleFraBuilder addInstrumentType(InstrumentType instrumentType);
		@Override
		SimpleFra.SimpleFraBuilder addInstrumentType(InstrumentType instrumentType, int idx);
		@Override
		SimpleFra.SimpleFraBuilder addInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		SimpleFra.SimpleFraBuilder setInstrumentType(List<? extends InstrumentType> instrumentType);
		@Override
		SimpleFra.SimpleFraBuilder setDescription(String description);
		@Override
		SimpleFra.SimpleFraBuilder setCurrency(IdentifiedCurrency currency);
		@Override
		SimpleFra.SimpleFraBuilder setExchangeId(ExchangeId exchangeId);
		@Override
		SimpleFra.SimpleFraBuilder setClearanceSystem(ClearanceSystem clearanceSystem);
		@Override
		SimpleFra.SimpleFraBuilder setDefinition(ProductReference definition);
		SimpleFra.SimpleFraBuilder setStartTerm(Period startTerm);
		SimpleFra.SimpleFraBuilder setEndTerm(Period endTerm);
		SimpleFra.SimpleFraBuilder setDayCountFraction(DayCountFraction dayCountFraction);

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
			processRosetta(path.newSubPath("startTerm"), processor, Period.PeriodBuilder.class, getStartTerm());
			processRosetta(path.newSubPath("endTerm"), processor, Period.PeriodBuilder.class, getEndTerm());
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
		}
		

		SimpleFra.SimpleFraBuilder prune();
	}

	/*********************** Immutable Implementation of SimpleFra  ***********************/
	class SimpleFraImpl extends UnderlyingAsset.UnderlyingAssetImpl implements SimpleFra {
		private final Period startTerm;
		private final Period endTerm;
		private final DayCountFraction dayCountFraction;
		
		protected SimpleFraImpl(SimpleFra.SimpleFraBuilder builder) {
			super(builder);
			this.startTerm = ofNullable(builder.getStartTerm()).map(f->f.build()).orElse(null);
			this.endTerm = ofNullable(builder.getEndTerm()).map(f->f.build()).orElse(null);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("startTerm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startTerm")
		public Period getStartTerm() {
			return startTerm;
		}
		
		@Override
		@RosettaAttribute("endTerm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endTerm")
		public Period getEndTerm() {
			return endTerm;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public SimpleFra build() {
			return this;
		}
		
		@Override
		public SimpleFra.SimpleFraBuilder toBuilder() {
			SimpleFra.SimpleFraBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimpleFra.SimpleFraBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getStartTerm()).ifPresent(builder::setStartTerm);
			ofNullable(getEndTerm()).ifPresent(builder::setEndTerm);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimpleFra _that = getType().cast(o);
		
			if (!Objects.equals(startTerm, _that.getStartTerm())) return false;
			if (!Objects.equals(endTerm, _that.getEndTerm())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startTerm != null ? startTerm.hashCode() : 0);
			_result = 31 * _result + (endTerm != null ? endTerm.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleFra {" +
				"startTerm=" + this.startTerm + ", " +
				"endTerm=" + this.endTerm + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of SimpleFra  ***********************/
	class SimpleFraBuilderImpl extends UnderlyingAsset.UnderlyingAssetBuilderImpl implements SimpleFra.SimpleFraBuilder {
	
		protected Period.PeriodBuilder startTerm;
		protected Period.PeriodBuilder endTerm;
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		
		@Override
		@RosettaAttribute("startTerm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startTerm")
		public Period.PeriodBuilder getStartTerm() {
			return startTerm;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateStartTerm() {
			Period.PeriodBuilder result;
			if (startTerm!=null) {
				result = startTerm;
			}
			else {
				result = startTerm = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("endTerm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endTerm")
		public Period.PeriodBuilder getEndTerm() {
			return endTerm;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateEndTerm() {
			Period.PeriodBuilder result;
			if (endTerm!=null) {
				result = endTerm;
			}
			else {
				result = endTerm = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public SimpleFra.SimpleFraBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public SimpleFra.SimpleFraBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public SimpleFra.SimpleFraBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public SimpleFra.SimpleFraBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public SimpleFra.SimpleFraBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public SimpleFra.SimpleFraBuilder addInstrumentType(InstrumentType _instrumentType) {
			if (_instrumentType != null) {
				this.instrumentType.add(_instrumentType.toBuilder());
			}
			return this;
		}
		
		@Override
		public SimpleFra.SimpleFraBuilder addInstrumentType(InstrumentType _instrumentType, int idx) {
			getIndex(this.instrumentType, idx, () -> _instrumentType.toBuilder());
			return this;
		}
		
		@Override
		public SimpleFra.SimpleFraBuilder addInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public SimpleFra.SimpleFraBuilder setInstrumentType(List<? extends InstrumentType> instrumentTypes) {
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
		public SimpleFra.SimpleFraBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public SimpleFra.SimpleFraBuilder setCurrency(IdentifiedCurrency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exchangeId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exchangeId")
		@Override
		public SimpleFra.SimpleFraBuilder setExchangeId(ExchangeId _exchangeId) {
			this.exchangeId = _exchangeId == null ? null : _exchangeId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearanceSystem")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystem")
		@Override
		public SimpleFra.SimpleFraBuilder setClearanceSystem(ClearanceSystem _clearanceSystem) {
			this.clearanceSystem = _clearanceSystem == null ? null : _clearanceSystem.toBuilder();
			return this;
		}
		
		@RosettaAttribute("definition")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definition")
		@Override
		public SimpleFra.SimpleFraBuilder setDefinition(ProductReference _definition) {
			this.definition = _definition == null ? null : _definition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startTerm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startTerm")
		@Override
		public SimpleFra.SimpleFraBuilder setStartTerm(Period _startTerm) {
			this.startTerm = _startTerm == null ? null : _startTerm.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endTerm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endTerm")
		@Override
		public SimpleFra.SimpleFraBuilder setEndTerm(Period _endTerm) {
			this.endTerm = _endTerm == null ? null : _endTerm.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public SimpleFra.SimpleFraBuilder setDayCountFraction(DayCountFraction _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction.toBuilder();
			return this;
		}
		
		@Override
		public SimpleFra build() {
			return new SimpleFra.SimpleFraImpl(this);
		}
		
		@Override
		public SimpleFra.SimpleFraBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleFra.SimpleFraBuilder prune() {
			super.prune();
			if (startTerm!=null && !startTerm.prune().hasData()) startTerm = null;
			if (endTerm!=null && !endTerm.prune().hasData()) endTerm = null;
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getStartTerm()!=null && getStartTerm().hasData()) return true;
			if (getEndTerm()!=null && getEndTerm().hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimpleFra.SimpleFraBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			SimpleFra.SimpleFraBuilder o = (SimpleFra.SimpleFraBuilder) other;
			
			merger.mergeRosetta(getStartTerm(), o.getStartTerm(), this::setStartTerm);
			merger.mergeRosetta(getEndTerm(), o.getEndTerm(), this::setEndTerm);
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SimpleFra _that = getType().cast(o);
		
			if (!Objects.equals(startTerm, _that.getStartTerm())) return false;
			if (!Objects.equals(endTerm, _that.getEndTerm())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (startTerm != null ? startTerm.hashCode() : 0);
			_result = 31 * _result + (endTerm != null ? endTerm.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimpleFraBuilder {" +
				"startTerm=" + this.startTerm + ", " +
				"endTerm=" + this.endTerm + ", " +
				"dayCountFraction=" + this.dayCountFraction +
			'}' + " " + super.toString();
		}
	}
}
