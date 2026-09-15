package iso20022.auth030.esma;

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
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import iso20022.auth030.esma.meta.OptionOrSwaption10__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Option or swaption related attributes.
 * @version ${project.version}
 */
@RosettaDataType(value="OptionOrSwaption10__1", builder=OptionOrSwaption10__1.OptionOrSwaption10__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OptionOrSwaption10__1", model="iso20022", builder=OptionOrSwaption10__1.OptionOrSwaption10__1BuilderImpl.class, version="${project.version}")
public interface OptionOrSwaption10__1 extends RosettaModelObject {

	OptionOrSwaption10__1Meta metaData = new OptionOrSwaption10__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the type of the Option whether it is a call option (right to purchase a specific underlying asset) or a put option (right to sell a specific underlying asset).
	 */
	OptionType2Code getTp();
	/**
	 * Indication as to whether the option may be exercised only at a fixed date (European, and Asian style), a series of pre-specified dates (Bermudan) or at any time during the life of the contract (American style). This field does not have to be populated for ISIN instruments.
	 */
	OptionStyle6Code__1 getExrcStyle();
	/**
	 * Specifies the predetermined price at which the owner of the option can buy or sell the underlying instrument.  Usage: For foreign exchange options, specifies the exchange rate at which the option can be exercised as the rate of exchange from converting the unit currency into the quoted currency. For volatility and variance swaps, specify the volatility strike price.
	 */
	SecuritiesTransactionPrice17Choice__1 getStrkPric();
	/**
	 * Specifies the effective date and end date of the schedule for derivative transactions with strike prices varying throughout the life of the transaction.
	 */
	List<? extends Schedule4__1> getStrkPricSchdl();
	/**
	 * Specifies the monetary amount of the premium paid by the buyer of the option.
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount__1 getPrmAmt();
	/**
	 * Specifies the date on which the option premium is paid.
	 */
	Date getPrmPmtDt();
	/**
	 * In case of swaptions, maturity date of the underlying swap.
	 */
	Date getMtrtyDtOfUndrlyg();

	/*********************** Build Methods  ***********************/
	OptionOrSwaption10__1 build();
	
	OptionOrSwaption10__1.OptionOrSwaption10__1Builder toBuilder();
	
	static OptionOrSwaption10__1.OptionOrSwaption10__1Builder builder() {
		return new OptionOrSwaption10__1.OptionOrSwaption10__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionOrSwaption10__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionOrSwaption10__1> getType() {
		return OptionOrSwaption10__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), OptionType2Code.class, getTp(), this);
		processor.processBasic(path.newSubPath("exrcStyle"), OptionStyle6Code__1.class, getExrcStyle(), this);
		processRosetta(path.newSubPath("strkPric"), processor, SecuritiesTransactionPrice17Choice__1.class, getStrkPric());
		processRosetta(path.newSubPath("strkPricSchdl"), processor, Schedule4__1.class, getStrkPricSchdl());
		processRosetta(path.newSubPath("prmAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount__1.class, getPrmAmt());
		processor.processBasic(path.newSubPath("prmPmtDt"), Date.class, getPrmPmtDt(), this);
		processor.processBasic(path.newSubPath("mtrtyDtOfUndrlyg"), Date.class, getMtrtyDtOfUndrlyg(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionOrSwaption10__1Builder extends OptionOrSwaption10__1, RosettaModelObjectBuilder {
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getOrCreateStrkPric();
		@Override
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getStrkPric();
		Schedule4__1.Schedule4__1Builder getOrCreateStrkPricSchdl(int index);
		@Override
		List<? extends Schedule4__1.Schedule4__1Builder> getStrkPricSchdl();
		ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder getOrCreatePrmAmt();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder getPrmAmt();
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder setTp(OptionType2Code tp);
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder setExrcStyle(OptionStyle6Code__1 exrcStyle);
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder setStrkPric(SecuritiesTransactionPrice17Choice__1 strkPric);
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder addStrkPricSchdl(Schedule4__1 strkPricSchdl);
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder addStrkPricSchdl(Schedule4__1 strkPricSchdl, int idx);
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder addStrkPricSchdl(List<? extends Schedule4__1> strkPricSchdl);
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder setStrkPricSchdl(List<? extends Schedule4__1> strkPricSchdl);
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder setPrmAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1 prmAmt);
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder setPrmPmtDt(Date prmPmtDt);
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder setMtrtyDtOfUndrlyg(Date mtrtyDtOfUndrlyg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), OptionType2Code.class, getTp(), this);
			processor.processBasic(path.newSubPath("exrcStyle"), OptionStyle6Code__1.class, getExrcStyle(), this);
			processRosetta(path.newSubPath("strkPric"), processor, SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder.class, getStrkPric());
			processRosetta(path.newSubPath("strkPricSchdl"), processor, Schedule4__1.Schedule4__1Builder.class, getStrkPricSchdl());
			processRosetta(path.newSubPath("prmAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder.class, getPrmAmt());
			processor.processBasic(path.newSubPath("prmPmtDt"), Date.class, getPrmPmtDt(), this);
			processor.processBasic(path.newSubPath("mtrtyDtOfUndrlyg"), Date.class, getMtrtyDtOfUndrlyg(), this);
		}
		

		OptionOrSwaption10__1.OptionOrSwaption10__1Builder prune();
	}

	/*********************** Immutable Implementation of OptionOrSwaption10__1  ***********************/
	class OptionOrSwaption10__1Impl implements OptionOrSwaption10__1 {
		private final OptionType2Code tp;
		private final OptionStyle6Code__1 exrcStyle;
		private final SecuritiesTransactionPrice17Choice__1 strkPric;
		private final List<? extends Schedule4__1> strkPricSchdl;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount__1 prmAmt;
		private final Date prmPmtDt;
		private final Date mtrtyDtOfUndrlyg;
		
		protected OptionOrSwaption10__1Impl(OptionOrSwaption10__1.OptionOrSwaption10__1Builder builder) {
			this.tp = builder.getTp();
			this.exrcStyle = builder.getExrcStyle();
			this.strkPric = ofNullable(builder.getStrkPric()).map(f->f.build()).orElse(null);
			this.strkPricSchdl = ofNullable(builder.getStrkPricSchdl()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.prmAmt = ofNullable(builder.getPrmAmt()).map(f->f.build()).orElse(null);
			this.prmPmtDt = builder.getPrmPmtDt();
			this.mtrtyDtOfUndrlyg = builder.getMtrtyDtOfUndrlyg();
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tp")
		public OptionType2Code getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("exrcStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exrcStyle")
		public OptionStyle6Code__1 getExrcStyle() {
			return exrcStyle;
		}
		
		@Override
		@RosettaAttribute("strkPric")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strkPric")
		public SecuritiesTransactionPrice17Choice__1 getStrkPric() {
			return strkPric;
		}
		
		@Override
		@RosettaAttribute("strkPricSchdl")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strkPricSchdl")
		public List<? extends Schedule4__1> getStrkPricSchdl() {
			return strkPricSchdl;
		}
		
		@Override
		@RosettaAttribute("prmAmt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prmAmt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1 getPrmAmt() {
			return prmAmt;
		}
		
		@Override
		@RosettaAttribute("prmPmtDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prmPmtDt")
		public Date getPrmPmtDt() {
			return prmPmtDt;
		}
		
		@Override
		@RosettaAttribute("mtrtyDtOfUndrlyg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mtrtyDtOfUndrlyg")
		public Date getMtrtyDtOfUndrlyg() {
			return mtrtyDtOfUndrlyg;
		}
		
		@Override
		public OptionOrSwaption10__1 build() {
			return this;
		}
		
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder toBuilder() {
			OptionOrSwaption10__1.OptionOrSwaption10__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionOrSwaption10__1.OptionOrSwaption10__1Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
			ofNullable(getExrcStyle()).ifPresent(builder::setExrcStyle);
			ofNullable(getStrkPric()).ifPresent(builder::setStrkPric);
			ofNullable(getStrkPricSchdl()).ifPresent(builder::setStrkPricSchdl);
			ofNullable(getPrmAmt()).ifPresent(builder::setPrmAmt);
			ofNullable(getPrmPmtDt()).ifPresent(builder::setPrmPmtDt);
			ofNullable(getMtrtyDtOfUndrlyg()).ifPresent(builder::setMtrtyDtOfUndrlyg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionOrSwaption10__1 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(exrcStyle, _that.getExrcStyle())) return false;
			if (!Objects.equals(strkPric, _that.getStrkPric())) return false;
			if (!ListEquals.listEquals(strkPricSchdl, _that.getStrkPricSchdl())) return false;
			if (!Objects.equals(prmAmt, _that.getPrmAmt())) return false;
			if (!Objects.equals(prmPmtDt, _that.getPrmPmtDt())) return false;
			if (!Objects.equals(mtrtyDtOfUndrlyg, _that.getMtrtyDtOfUndrlyg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exrcStyle != null ? exrcStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strkPric != null ? strkPric.hashCode() : 0);
			_result = 31 * _result + (strkPricSchdl != null ? strkPricSchdl.hashCode() : 0);
			_result = 31 * _result + (prmAmt != null ? prmAmt.hashCode() : 0);
			_result = 31 * _result + (prmPmtDt != null ? prmPmtDt.hashCode() : 0);
			_result = 31 * _result + (mtrtyDtOfUndrlyg != null ? mtrtyDtOfUndrlyg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionOrSwaption10__1 {" +
				"tp=" + this.tp + ", " +
				"exrcStyle=" + this.exrcStyle + ", " +
				"strkPric=" + this.strkPric + ", " +
				"strkPricSchdl=" + this.strkPricSchdl + ", " +
				"prmAmt=" + this.prmAmt + ", " +
				"prmPmtDt=" + this.prmPmtDt + ", " +
				"mtrtyDtOfUndrlyg=" + this.mtrtyDtOfUndrlyg +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionOrSwaption10__1  ***********************/
	class OptionOrSwaption10__1BuilderImpl implements OptionOrSwaption10__1.OptionOrSwaption10__1Builder {
	
		protected OptionType2Code tp;
		protected OptionStyle6Code__1 exrcStyle;
		protected SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder strkPric;
		protected List<Schedule4__1.Schedule4__1Builder> strkPricSchdl = new ArrayList<>();
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder prmAmt;
		protected Date prmPmtDt;
		protected Date mtrtyDtOfUndrlyg;
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tp")
		public OptionType2Code getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("exrcStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exrcStyle")
		public OptionStyle6Code__1 getExrcStyle() {
			return exrcStyle;
		}
		
		@Override
		@RosettaAttribute("strkPric")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strkPric")
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getStrkPric() {
			return strkPric;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getOrCreateStrkPric() {
			SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder result;
			if (strkPric!=null) {
				result = strkPric;
			}
			else {
				result = strkPric = SecuritiesTransactionPrice17Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strkPricSchdl")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("strkPricSchdl")
		public List<? extends Schedule4__1.Schedule4__1Builder> getStrkPricSchdl() {
			return strkPricSchdl;
		}
		
		@Override
		public Schedule4__1.Schedule4__1Builder getOrCreateStrkPricSchdl(int index) {
			if (strkPricSchdl==null) {
				this.strkPricSchdl = new ArrayList<>();
			}
			return getIndex(strkPricSchdl, index, () -> {
						Schedule4__1.Schedule4__1Builder newStrkPricSchdl = Schedule4__1.builder();
						return newStrkPricSchdl;
					});
		}
		
		@Override
		@RosettaAttribute("prmAmt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prmAmt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder getPrmAmt() {
			return prmAmt;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder getOrCreatePrmAmt() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder result;
			if (prmAmt!=null) {
				result = prmAmt;
			}
			else {
				result = prmAmt = ActiveOrHistoricCurrencyAnd5DecimalAmount__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prmPmtDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prmPmtDt")
		public Date getPrmPmtDt() {
			return prmPmtDt;
		}
		
		@Override
		@RosettaAttribute("mtrtyDtOfUndrlyg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mtrtyDtOfUndrlyg")
		public Date getMtrtyDtOfUndrlyg() {
			return mtrtyDtOfUndrlyg;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tp")
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder setTp(OptionType2Code _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@RosettaAttribute("exrcStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exrcStyle")
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder setExrcStyle(OptionStyle6Code__1 _exrcStyle) {
			this.exrcStyle = _exrcStyle == null ? null : _exrcStyle;
			return this;
		}
		
		@RosettaAttribute("strkPric")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strkPric")
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder setStrkPric(SecuritiesTransactionPrice17Choice__1 _strkPric) {
			this.strkPric = _strkPric == null ? null : _strkPric.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strkPricSchdl")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("strkPricSchdl")
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder addStrkPricSchdl(Schedule4__1 _strkPricSchdl) {
			if (_strkPricSchdl != null) {
				this.strkPricSchdl.add(_strkPricSchdl.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder addStrkPricSchdl(Schedule4__1 _strkPricSchdl, int idx) {
			getIndex(this.strkPricSchdl, idx, () -> _strkPricSchdl.toBuilder());
			return this;
		}
		
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder addStrkPricSchdl(List<? extends Schedule4__1> strkPricSchdls) {
			if (strkPricSchdls != null) {
				for (final Schedule4__1 toAdd : strkPricSchdls) {
					this.strkPricSchdl.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("strkPricSchdl")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("strkPricSchdl")
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder setStrkPricSchdl(List<? extends Schedule4__1> strkPricSchdls) {
			if (strkPricSchdls == null) {
				this.strkPricSchdl = new ArrayList<>();
			} else {
				this.strkPricSchdl = strkPricSchdls.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("prmAmt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prmAmt")
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder setPrmAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1 _prmAmt) {
			this.prmAmt = _prmAmt == null ? null : _prmAmt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prmPmtDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prmPmtDt")
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder setPrmPmtDt(Date _prmPmtDt) {
			this.prmPmtDt = _prmPmtDt == null ? null : _prmPmtDt;
			return this;
		}
		
		@RosettaAttribute("mtrtyDtOfUndrlyg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mtrtyDtOfUndrlyg")
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder setMtrtyDtOfUndrlyg(Date _mtrtyDtOfUndrlyg) {
			this.mtrtyDtOfUndrlyg = _mtrtyDtOfUndrlyg == null ? null : _mtrtyDtOfUndrlyg;
			return this;
		}
		
		@Override
		public OptionOrSwaption10__1 build() {
			return new OptionOrSwaption10__1.OptionOrSwaption10__1Impl(this);
		}
		
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder prune() {
			if (strkPric!=null && !strkPric.prune().hasData()) strkPric = null;
			strkPricSchdl = strkPricSchdl.stream().filter(b->b!=null).<Schedule4__1.Schedule4__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (prmAmt!=null && !prmAmt.prune().hasData()) prmAmt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null) return true;
			if (getExrcStyle()!=null) return true;
			if (getStrkPric()!=null && getStrkPric().hasData()) return true;
			if (getStrkPricSchdl()!=null && getStrkPricSchdl().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPrmAmt()!=null && getPrmAmt().hasData()) return true;
			if (getPrmPmtDt()!=null) return true;
			if (getMtrtyDtOfUndrlyg()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionOrSwaption10__1.OptionOrSwaption10__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionOrSwaption10__1.OptionOrSwaption10__1Builder o = (OptionOrSwaption10__1.OptionOrSwaption10__1Builder) other;
			
			merger.mergeRosetta(getStrkPric(), o.getStrkPric(), this::setStrkPric);
			merger.mergeRosetta(getStrkPricSchdl(), o.getStrkPricSchdl(), this::getOrCreateStrkPricSchdl);
			merger.mergeRosetta(getPrmAmt(), o.getPrmAmt(), this::setPrmAmt);
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			merger.mergeBasic(getExrcStyle(), o.getExrcStyle(), this::setExrcStyle);
			merger.mergeBasic(getPrmPmtDt(), o.getPrmPmtDt(), this::setPrmPmtDt);
			merger.mergeBasic(getMtrtyDtOfUndrlyg(), o.getMtrtyDtOfUndrlyg(), this::setMtrtyDtOfUndrlyg);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionOrSwaption10__1 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(exrcStyle, _that.getExrcStyle())) return false;
			if (!Objects.equals(strkPric, _that.getStrkPric())) return false;
			if (!ListEquals.listEquals(strkPricSchdl, _that.getStrkPricSchdl())) return false;
			if (!Objects.equals(prmAmt, _that.getPrmAmt())) return false;
			if (!Objects.equals(prmPmtDt, _that.getPrmPmtDt())) return false;
			if (!Objects.equals(mtrtyDtOfUndrlyg, _that.getMtrtyDtOfUndrlyg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exrcStyle != null ? exrcStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strkPric != null ? strkPric.hashCode() : 0);
			_result = 31 * _result + (strkPricSchdl != null ? strkPricSchdl.hashCode() : 0);
			_result = 31 * _result + (prmAmt != null ? prmAmt.hashCode() : 0);
			_result = 31 * _result + (prmPmtDt != null ? prmPmtDt.hashCode() : 0);
			_result = 31 * _result + (mtrtyDtOfUndrlyg != null ? mtrtyDtOfUndrlyg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionOrSwaption10__1Builder {" +
				"tp=" + this.tp + ", " +
				"exrcStyle=" + this.exrcStyle + ", " +
				"strkPric=" + this.strkPric + ", " +
				"strkPricSchdl=" + this.strkPricSchdl + ", " +
				"prmAmt=" + this.prmAmt + ", " +
				"prmPmtDt=" + this.prmPmtDt + ", " +
				"mtrtyDtOfUndrlyg=" + this.mtrtyDtOfUndrlyg +
			'}';
		}
	}
}
