package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.loan.meta.LoanTradingCostOfCarryAccrualMeta;
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
 * version "confirmation-5.13"
 *
 * Provision A schedule that incorporates all sub-periods of an accrual calculation for the purposes of determining the cost of carry in the case of a trade with delayed settlement.
 *
 */
@RosettaDataType(value="LoanTradingCostOfCarryAccrual", builder=LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradingCostOfCarryAccrual", model="fpml", builder=LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilderImpl.class, version="2.1.1")
public interface LoanTradingCostOfCarryAccrual extends RosettaModelObject {

	LoanTradingCostOfCarryAccrualMeta metaData = new LoanTradingCostOfCarryAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The funded and unfunded utilization details. These figures together with the commitment adjustment and non-recurring fees would be used to calculate the trade amount on a daily basis. If using the commencement amount, as of regular settlement date, then it is only necessary to define the utilization as of that single date. If using the settlement amount calculation (for each day through the settlement period), then it will be necessary to provide a schedule of utilized/unutilized balances throught the entire period.
	 *
	 */
	List<? extends UtilizationPeriod> getUtilizationPeriod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The accrual associated with a simple commencement amount based calculation.
	 *
	 */
	AccrualPeriod getCommencementAccrual();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An array of accrual periods which define a single accrual schedule.
	 *
	 */
	List<? extends AccrualPeriod> getSettlementPeriodAccrual();

	/*********************** Build Methods  ***********************/
	LoanTradingCostOfCarryAccrual build();
	
	LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder toBuilder();
	
	static LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder builder() {
		return new LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingCostOfCarryAccrual> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradingCostOfCarryAccrual> getType() {
		return LoanTradingCostOfCarryAccrual.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("utilizationPeriod"), processor, UtilizationPeriod.class, getUtilizationPeriod());
		processRosetta(path.newSubPath("commencementAccrual"), processor, AccrualPeriod.class, getCommencementAccrual());
		processRosetta(path.newSubPath("settlementPeriodAccrual"), processor, AccrualPeriod.class, getSettlementPeriodAccrual());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingCostOfCarryAccrualBuilder extends LoanTradingCostOfCarryAccrual, RosettaModelObjectBuilder {
		UtilizationPeriod.UtilizationPeriodBuilder getOrCreateUtilizationPeriod(int index);
		@Override
		List<? extends UtilizationPeriod.UtilizationPeriodBuilder> getUtilizationPeriod();
		AccrualPeriod.AccrualPeriodBuilder getOrCreateCommencementAccrual();
		@Override
		AccrualPeriod.AccrualPeriodBuilder getCommencementAccrual();
		AccrualPeriod.AccrualPeriodBuilder getOrCreateSettlementPeriodAccrual(int index);
		@Override
		List<? extends AccrualPeriod.AccrualPeriodBuilder> getSettlementPeriodAccrual();
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addUtilizationPeriod(UtilizationPeriod utilizationPeriod);
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addUtilizationPeriod(UtilizationPeriod utilizationPeriod, int idx);
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addUtilizationPeriod(List<? extends UtilizationPeriod> utilizationPeriod);
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder setUtilizationPeriod(List<? extends UtilizationPeriod> utilizationPeriod);
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder setCommencementAccrual(AccrualPeriod commencementAccrual);
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addSettlementPeriodAccrual(AccrualPeriod settlementPeriodAccrual);
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addSettlementPeriodAccrual(AccrualPeriod settlementPeriodAccrual, int idx);
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addSettlementPeriodAccrual(List<? extends AccrualPeriod> settlementPeriodAccrual);
		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder setSettlementPeriodAccrual(List<? extends AccrualPeriod> settlementPeriodAccrual);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("utilizationPeriod"), processor, UtilizationPeriod.UtilizationPeriodBuilder.class, getUtilizationPeriod());
			processRosetta(path.newSubPath("commencementAccrual"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getCommencementAccrual());
			processRosetta(path.newSubPath("settlementPeriodAccrual"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getSettlementPeriodAccrual());
		}
		

		LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingCostOfCarryAccrual  ***********************/
	class LoanTradingCostOfCarryAccrualImpl implements LoanTradingCostOfCarryAccrual {
		private final List<? extends UtilizationPeriod> utilizationPeriod;
		private final AccrualPeriod commencementAccrual;
		private final List<? extends AccrualPeriod> settlementPeriodAccrual;
		
		protected LoanTradingCostOfCarryAccrualImpl(LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder builder) {
			this.utilizationPeriod = ofNullable(builder.getUtilizationPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commencementAccrual = ofNullable(builder.getCommencementAccrual()).map(f->f.build()).orElse(null);
			this.settlementPeriodAccrual = ofNullable(builder.getSettlementPeriodAccrual()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("utilizationPeriod")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("utilizationPeriod")
		public List<? extends UtilizationPeriod> getUtilizationPeriod() {
			return utilizationPeriod;
		}
		
		@Override
		@RosettaAttribute("commencementAccrual")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commencementAccrual")
		public AccrualPeriod getCommencementAccrual() {
			return commencementAccrual;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodAccrual")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodAccrual")
		public List<? extends AccrualPeriod> getSettlementPeriodAccrual() {
			return settlementPeriodAccrual;
		}
		
		@Override
		public LoanTradingCostOfCarryAccrual build() {
			return this;
		}
		
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder toBuilder() {
			LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder builder) {
			ofNullable(getUtilizationPeriod()).ifPresent(builder::setUtilizationPeriod);
			ofNullable(getCommencementAccrual()).ifPresent(builder::setCommencementAccrual);
			ofNullable(getSettlementPeriodAccrual()).ifPresent(builder::setSettlementPeriodAccrual);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCostOfCarryAccrual _that = getType().cast(o);
		
			if (!ListEquals.listEquals(utilizationPeriod, _that.getUtilizationPeriod())) return false;
			if (!Objects.equals(commencementAccrual, _that.getCommencementAccrual())) return false;
			if (!ListEquals.listEquals(settlementPeriodAccrual, _that.getSettlementPeriodAccrual())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (utilizationPeriod != null ? utilizationPeriod.hashCode() : 0);
			_result = 31 * _result + (commencementAccrual != null ? commencementAccrual.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodAccrual != null ? settlementPeriodAccrual.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCostOfCarryAccrual {" +
				"utilizationPeriod=" + this.utilizationPeriod + ", " +
				"commencementAccrual=" + this.commencementAccrual + ", " +
				"settlementPeriodAccrual=" + this.settlementPeriodAccrual +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingCostOfCarryAccrual  ***********************/
	class LoanTradingCostOfCarryAccrualBuilderImpl implements LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder {
	
		protected List<UtilizationPeriod.UtilizationPeriodBuilder> utilizationPeriod = new ArrayList<>();
		protected AccrualPeriod.AccrualPeriodBuilder commencementAccrual;
		protected List<AccrualPeriod.AccrualPeriodBuilder> settlementPeriodAccrual = new ArrayList<>();
		
		@Override
		@RosettaAttribute("utilizationPeriod")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("utilizationPeriod")
		public List<? extends UtilizationPeriod.UtilizationPeriodBuilder> getUtilizationPeriod() {
			return utilizationPeriod;
		}
		
		@Override
		public UtilizationPeriod.UtilizationPeriodBuilder getOrCreateUtilizationPeriod(int index) {
			if (utilizationPeriod==null) {
				this.utilizationPeriod = new ArrayList<>();
			}
			return getIndex(utilizationPeriod, index, () -> {
						UtilizationPeriod.UtilizationPeriodBuilder newUtilizationPeriod = UtilizationPeriod.builder();
						return newUtilizationPeriod;
					});
		}
		
		@Override
		@RosettaAttribute("commencementAccrual")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commencementAccrual")
		public AccrualPeriod.AccrualPeriodBuilder getCommencementAccrual() {
			return commencementAccrual;
		}
		
		@Override
		public AccrualPeriod.AccrualPeriodBuilder getOrCreateCommencementAccrual() {
			AccrualPeriod.AccrualPeriodBuilder result;
			if (commencementAccrual!=null) {
				result = commencementAccrual;
			}
			else {
				result = commencementAccrual = AccrualPeriod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodAccrual")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodAccrual")
		public List<? extends AccrualPeriod.AccrualPeriodBuilder> getSettlementPeriodAccrual() {
			return settlementPeriodAccrual;
		}
		
		@Override
		public AccrualPeriod.AccrualPeriodBuilder getOrCreateSettlementPeriodAccrual(int index) {
			if (settlementPeriodAccrual==null) {
				this.settlementPeriodAccrual = new ArrayList<>();
			}
			return getIndex(settlementPeriodAccrual, index, () -> {
						AccrualPeriod.AccrualPeriodBuilder newSettlementPeriodAccrual = AccrualPeriod.builder();
						return newSettlementPeriodAccrual;
					});
		}
		
		@RosettaAttribute("utilizationPeriod")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("utilizationPeriod")
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addUtilizationPeriod(UtilizationPeriod _utilizationPeriod) {
			if (_utilizationPeriod != null) {
				this.utilizationPeriod.add(_utilizationPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addUtilizationPeriod(UtilizationPeriod _utilizationPeriod, int idx) {
			getIndex(this.utilizationPeriod, idx, () -> _utilizationPeriod.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addUtilizationPeriod(List<? extends UtilizationPeriod> utilizationPeriods) {
			if (utilizationPeriods != null) {
				for (final UtilizationPeriod toAdd : utilizationPeriods) {
					this.utilizationPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("utilizationPeriod")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("utilizationPeriod")
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder setUtilizationPeriod(List<? extends UtilizationPeriod> utilizationPeriods) {
			if (utilizationPeriods == null) {
				this.utilizationPeriod = new ArrayList<>();
			} else {
				this.utilizationPeriod = utilizationPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("commencementAccrual")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commencementAccrual")
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder setCommencementAccrual(AccrualPeriod _commencementAccrual) {
			this.commencementAccrual = _commencementAccrual == null ? null : _commencementAccrual.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriodAccrual")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodAccrual")
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addSettlementPeriodAccrual(AccrualPeriod _settlementPeriodAccrual) {
			if (_settlementPeriodAccrual != null) {
				this.settlementPeriodAccrual.add(_settlementPeriodAccrual.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addSettlementPeriodAccrual(AccrualPeriod _settlementPeriodAccrual, int idx) {
			getIndex(this.settlementPeriodAccrual, idx, () -> _settlementPeriodAccrual.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder addSettlementPeriodAccrual(List<? extends AccrualPeriod> settlementPeriodAccruals) {
			if (settlementPeriodAccruals != null) {
				for (final AccrualPeriod toAdd : settlementPeriodAccruals) {
					this.settlementPeriodAccrual.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodAccrual")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodAccrual")
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder setSettlementPeriodAccrual(List<? extends AccrualPeriod> settlementPeriodAccruals) {
			if (settlementPeriodAccruals == null) {
				this.settlementPeriodAccrual = new ArrayList<>();
			} else {
				this.settlementPeriodAccrual = settlementPeriodAccruals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanTradingCostOfCarryAccrual build() {
			return new LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualImpl(this);
		}
		
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder prune() {
			utilizationPeriod = utilizationPeriod.stream().filter(b->b!=null).<UtilizationPeriod.UtilizationPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (commencementAccrual!=null && !commencementAccrual.prune().hasData()) commencementAccrual = null;
			settlementPeriodAccrual = settlementPeriodAccrual.stream().filter(b->b!=null).<AccrualPeriod.AccrualPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUtilizationPeriod()!=null && getUtilizationPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommencementAccrual()!=null && getCommencementAccrual().hasData()) return true;
			if (getSettlementPeriodAccrual()!=null && getSettlementPeriodAccrual().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder o = (LoanTradingCostOfCarryAccrual.LoanTradingCostOfCarryAccrualBuilder) other;
			
			merger.mergeRosetta(getUtilizationPeriod(), o.getUtilizationPeriod(), this::getOrCreateUtilizationPeriod);
			merger.mergeRosetta(getCommencementAccrual(), o.getCommencementAccrual(), this::setCommencementAccrual);
			merger.mergeRosetta(getSettlementPeriodAccrual(), o.getSettlementPeriodAccrual(), this::getOrCreateSettlementPeriodAccrual);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingCostOfCarryAccrual _that = getType().cast(o);
		
			if (!ListEquals.listEquals(utilizationPeriod, _that.getUtilizationPeriod())) return false;
			if (!Objects.equals(commencementAccrual, _that.getCommencementAccrual())) return false;
			if (!ListEquals.listEquals(settlementPeriodAccrual, _that.getSettlementPeriodAccrual())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (utilizationPeriod != null ? utilizationPeriod.hashCode() : 0);
			_result = 31 * _result + (commencementAccrual != null ? commencementAccrual.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodAccrual != null ? settlementPeriodAccrual.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingCostOfCarryAccrualBuilder {" +
				"utilizationPeriod=" + this.utilizationPeriod + ", " +
				"commencementAccrual=" + this.commencementAccrual + ", " +
				"settlementPeriodAccrual=" + this.settlementPeriodAccrual +
			'}';
		}
	}
}
