package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.ResetCalculationElementsMeta;
import fpml.consolidated.shared.CashflowNotional;
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
@RosettaDataType(value="ResetCalculationElements", builder=ResetCalculationElements.ResetCalculationElementsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ResetCalculationElements", model="fpml", builder=ResetCalculationElements.ResetCalculationElementsBuilderImpl.class, version="2.1.1")
public interface ResetCalculationElements extends RosettaModelObject {

	ResetCalculationElementsMeta metaData = new ResetCalculationElementsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the notional in effect for this calculation period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifies the notional in effect for this calculation period.
	 *
	 */
	CashflowNotional getNotional();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The computed rate(s) or price(s) used to calculate the amount of this reset. These computed rates or prices may include averaging and/or various types of rate treatment rules.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The computed rate(s) or price(s) used to calculate the amount of this reset. These computed rates or prices may include averaging and/or various types of rate treatment rules.
	 *
	 */
	CashflowFixing getCalculatedRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The period details for calculation/accrual periods that comprise this reset.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The period details for calculation/accrual periods that comprise this reset.
	 *
	 */
	ResetCalculationPeriod getCalculationPeriod();

	/*********************** Build Methods  ***********************/
	ResetCalculationElements build();
	
	ResetCalculationElements.ResetCalculationElementsBuilder toBuilder();
	
	static ResetCalculationElements.ResetCalculationElementsBuilder builder() {
		return new ResetCalculationElements.ResetCalculationElementsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResetCalculationElements> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ResetCalculationElements> getType() {
		return ResetCalculationElements.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notional"), processor, CashflowNotional.class, getNotional());
		processRosetta(path.newSubPath("calculatedRate"), processor, CashflowFixing.class, getCalculatedRate());
		processRosetta(path.newSubPath("calculationPeriod"), processor, ResetCalculationPeriod.class, getCalculationPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResetCalculationElementsBuilder extends ResetCalculationElements, RosettaModelObjectBuilder {
		CashflowNotional.CashflowNotionalBuilder getOrCreateNotional();
		@Override
		CashflowNotional.CashflowNotionalBuilder getNotional();
		CashflowFixing.CashflowFixingBuilder getOrCreateCalculatedRate();
		@Override
		CashflowFixing.CashflowFixingBuilder getCalculatedRate();
		ResetCalculationPeriod.ResetCalculationPeriodBuilder getOrCreateCalculationPeriod();
		@Override
		ResetCalculationPeriod.ResetCalculationPeriodBuilder getCalculationPeriod();
		ResetCalculationElements.ResetCalculationElementsBuilder setNotional(CashflowNotional notional);
		ResetCalculationElements.ResetCalculationElementsBuilder setCalculatedRate(CashflowFixing calculatedRate);
		ResetCalculationElements.ResetCalculationElementsBuilder setCalculationPeriod(ResetCalculationPeriod calculationPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notional"), processor, CashflowNotional.CashflowNotionalBuilder.class, getNotional());
			processRosetta(path.newSubPath("calculatedRate"), processor, CashflowFixing.CashflowFixingBuilder.class, getCalculatedRate());
			processRosetta(path.newSubPath("calculationPeriod"), processor, ResetCalculationPeriod.ResetCalculationPeriodBuilder.class, getCalculationPeriod());
		}
		

		ResetCalculationElements.ResetCalculationElementsBuilder prune();
	}

	/*********************** Immutable Implementation of ResetCalculationElements  ***********************/
	class ResetCalculationElementsImpl implements ResetCalculationElements {
		private final CashflowNotional notional;
		private final CashflowFixing calculatedRate;
		private final ResetCalculationPeriod calculationPeriod;
		
		protected ResetCalculationElementsImpl(ResetCalculationElements.ResetCalculationElementsBuilder builder) {
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.calculatedRate = ofNullable(builder.getCalculatedRate()).map(f->f.build()).orElse(null);
			this.calculationPeriod = ofNullable(builder.getCalculationPeriod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notional")
		public CashflowNotional getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("calculatedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculatedRate")
		public CashflowFixing getCalculatedRate() {
			return calculatedRate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriod")
		public ResetCalculationPeriod getCalculationPeriod() {
			return calculationPeriod;
		}
		
		@Override
		public ResetCalculationElements build() {
			return this;
		}
		
		@Override
		public ResetCalculationElements.ResetCalculationElementsBuilder toBuilder() {
			ResetCalculationElements.ResetCalculationElementsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetCalculationElements.ResetCalculationElementsBuilder builder) {
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getCalculatedRate()).ifPresent(builder::setCalculatedRate);
			ofNullable(getCalculationPeriod()).ifPresent(builder::setCalculationPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetCalculationElements _that = getType().cast(o);
		
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(calculatedRate, _that.getCalculatedRate())) return false;
			if (!Objects.equals(calculationPeriod, _that.getCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (calculatedRate != null ? calculatedRate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetCalculationElements {" +
				"notional=" + this.notional + ", " +
				"calculatedRate=" + this.calculatedRate + ", " +
				"calculationPeriod=" + this.calculationPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of ResetCalculationElements  ***********************/
	class ResetCalculationElementsBuilderImpl implements ResetCalculationElements.ResetCalculationElementsBuilder {
	
		protected CashflowNotional.CashflowNotionalBuilder notional;
		protected CashflowFixing.CashflowFixingBuilder calculatedRate;
		protected ResetCalculationPeriod.ResetCalculationPeriodBuilder calculationPeriod;
		
		@Override
		@RosettaAttribute("notional")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notional")
		public CashflowNotional.CashflowNotionalBuilder getNotional() {
			return notional;
		}
		
		@Override
		public CashflowNotional.CashflowNotionalBuilder getOrCreateNotional() {
			CashflowNotional.CashflowNotionalBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = CashflowNotional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculatedRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculatedRate")
		public CashflowFixing.CashflowFixingBuilder getCalculatedRate() {
			return calculatedRate;
		}
		
		@Override
		public CashflowFixing.CashflowFixingBuilder getOrCreateCalculatedRate() {
			CashflowFixing.CashflowFixingBuilder result;
			if (calculatedRate!=null) {
				result = calculatedRate;
			}
			else {
				result = calculatedRate = CashflowFixing.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriod")
		public ResetCalculationPeriod.ResetCalculationPeriodBuilder getCalculationPeriod() {
			return calculationPeriod;
		}
		
		@Override
		public ResetCalculationPeriod.ResetCalculationPeriodBuilder getOrCreateCalculationPeriod() {
			ResetCalculationPeriod.ResetCalculationPeriodBuilder result;
			if (calculationPeriod!=null) {
				result = calculationPeriod;
			}
			else {
				result = calculationPeriod = ResetCalculationPeriod.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("notional")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notional")
		@Override
		public ResetCalculationElements.ResetCalculationElementsBuilder setNotional(CashflowNotional _notional) {
			this.notional = _notional == null ? null : _notional.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculatedRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculatedRate")
		@Override
		public ResetCalculationElements.ResetCalculationElementsBuilder setCalculatedRate(CashflowFixing _calculatedRate) {
			this.calculatedRate = _calculatedRate == null ? null : _calculatedRate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriod")
		@Override
		public ResetCalculationElements.ResetCalculationElementsBuilder setCalculationPeriod(ResetCalculationPeriod _calculationPeriod) {
			this.calculationPeriod = _calculationPeriod == null ? null : _calculationPeriod.toBuilder();
			return this;
		}
		
		@Override
		public ResetCalculationElements build() {
			return new ResetCalculationElements.ResetCalculationElementsImpl(this);
		}
		
		@Override
		public ResetCalculationElements.ResetCalculationElementsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetCalculationElements.ResetCalculationElementsBuilder prune() {
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (calculatedRate!=null && !calculatedRate.prune().hasData()) calculatedRate = null;
			if (calculationPeriod!=null && !calculationPeriod.prune().hasData()) calculationPeriod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getCalculatedRate()!=null && getCalculatedRate().hasData()) return true;
			if (getCalculationPeriod()!=null && getCalculationPeriod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetCalculationElements.ResetCalculationElementsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResetCalculationElements.ResetCalculationElementsBuilder o = (ResetCalculationElements.ResetCalculationElementsBuilder) other;
			
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getCalculatedRate(), o.getCalculatedRate(), this::setCalculatedRate);
			merger.mergeRosetta(getCalculationPeriod(), o.getCalculationPeriod(), this::setCalculationPeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetCalculationElements _that = getType().cast(o);
		
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(calculatedRate, _that.getCalculatedRate())) return false;
			if (!Objects.equals(calculationPeriod, _that.getCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (calculatedRate != null ? calculatedRate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetCalculationElementsBuilder {" +
				"notional=" + this.notional + ", " +
				"calculatedRate=" + this.calculatedRate + ", " +
				"calculationPeriod=" + this.calculationPeriod +
			'}';
		}
	}
}
