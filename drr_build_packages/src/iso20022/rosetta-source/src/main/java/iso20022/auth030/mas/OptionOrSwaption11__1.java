package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.OptionOrSwaption11__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionOrSwaption11__1", builder=OptionOrSwaption11__1.OptionOrSwaption11__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OptionOrSwaption11__1", model="iso20022", builder=OptionOrSwaption11__1.OptionOrSwaption11__1BuilderImpl.class, version="${project.version}")
public interface OptionOrSwaption11__1 extends RosettaModelObject {

	OptionOrSwaption11__1Meta metaData = new OptionOrSwaption11__1Meta();

	/*********************** Getter Methods  ***********************/
	OptionType2Code getTp();
	OptionStyle6Code getExrcStyle();
	ExerciseDate1Choice__1 getExrcDt();
	SecuritiesTransactionPrice17Choice__1 getStrkPric();
	List<? extends Schedule4__1> getStrkPricSchdl();
	ActiveOrHistoricCurrencyAnd5DecimalAmount getCallAmt();
	ActiveOrHistoricCurrencyAnd5DecimalAmount getPutAmt();
	ActiveOrHistoricCurrencyAnd5DecimalAmount getPrmAmt();

	/*********************** Build Methods  ***********************/
	OptionOrSwaption11__1 build();
	
	OptionOrSwaption11__1.OptionOrSwaption11__1Builder toBuilder();
	
	static OptionOrSwaption11__1.OptionOrSwaption11__1Builder builder() {
		return new OptionOrSwaption11__1.OptionOrSwaption11__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionOrSwaption11__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionOrSwaption11__1> getType() {
		return OptionOrSwaption11__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), OptionType2Code.class, getTp(), this);
		processor.processBasic(path.newSubPath("exrcStyle"), OptionStyle6Code.class, getExrcStyle(), this);
		processRosetta(path.newSubPath("exrcDt"), processor, ExerciseDate1Choice__1.class, getExrcDt());
		processRosetta(path.newSubPath("strkPric"), processor, SecuritiesTransactionPrice17Choice__1.class, getStrkPric());
		processRosetta(path.newSubPath("strkPricSchdl"), processor, Schedule4__1.class, getStrkPricSchdl());
		processRosetta(path.newSubPath("callAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getCallAmt());
		processRosetta(path.newSubPath("putAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getPutAmt());
		processRosetta(path.newSubPath("prmAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getPrmAmt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionOrSwaption11__1Builder extends OptionOrSwaption11__1, RosettaModelObjectBuilder {
		ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder getOrCreateExrcDt();
		@Override
		ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder getExrcDt();
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getOrCreateStrkPric();
		@Override
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getStrkPric();
		Schedule4__1.Schedule4__1Builder getOrCreateStrkPricSchdl(int index);
		@Override
		List<? extends Schedule4__1.Schedule4__1Builder> getStrkPricSchdl();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateCallAmt();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getCallAmt();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreatePutAmt();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getPutAmt();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreatePrmAmt();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getPrmAmt();
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setTp(OptionType2Code tp);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setExrcStyle(OptionStyle6Code exrcStyle);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setExrcDt(ExerciseDate1Choice__1 exrcDt);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setStrkPric(SecuritiesTransactionPrice17Choice__1 strkPric);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder addStrkPricSchdl(Schedule4__1 strkPricSchdl);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder addStrkPricSchdl(Schedule4__1 strkPricSchdl, int idx);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder addStrkPricSchdl(List<? extends Schedule4__1> strkPricSchdl);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setStrkPricSchdl(List<? extends Schedule4__1> strkPricSchdl);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setCallAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount callAmt);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setPutAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount putAmt);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setPrmAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount prmAmt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), OptionType2Code.class, getTp(), this);
			processor.processBasic(path.newSubPath("exrcStyle"), OptionStyle6Code.class, getExrcStyle(), this);
			processRosetta(path.newSubPath("exrcDt"), processor, ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder.class, getExrcDt());
			processRosetta(path.newSubPath("strkPric"), processor, SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder.class, getStrkPric());
			processRosetta(path.newSubPath("strkPricSchdl"), processor, Schedule4__1.Schedule4__1Builder.class, getStrkPricSchdl());
			processRosetta(path.newSubPath("callAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getCallAmt());
			processRosetta(path.newSubPath("putAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getPutAmt());
			processRosetta(path.newSubPath("prmAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getPrmAmt());
		}
		

		OptionOrSwaption11__1.OptionOrSwaption11__1Builder prune();
	}

	/*********************** Immutable Implementation of OptionOrSwaption11__1  ***********************/
	class OptionOrSwaption11__1Impl implements OptionOrSwaption11__1 {
		private final OptionType2Code tp;
		private final OptionStyle6Code exrcStyle;
		private final ExerciseDate1Choice__1 exrcDt;
		private final SecuritiesTransactionPrice17Choice__1 strkPric;
		private final List<? extends Schedule4__1> strkPricSchdl;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount callAmt;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount putAmt;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount prmAmt;
		
		protected OptionOrSwaption11__1Impl(OptionOrSwaption11__1.OptionOrSwaption11__1Builder builder) {
			this.tp = builder.getTp();
			this.exrcStyle = builder.getExrcStyle();
			this.exrcDt = ofNullable(builder.getExrcDt()).map(f->f.build()).orElse(null);
			this.strkPric = ofNullable(builder.getStrkPric()).map(f->f.build()).orElse(null);
			this.strkPricSchdl = ofNullable(builder.getStrkPricSchdl()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.callAmt = ofNullable(builder.getCallAmt()).map(f->f.build()).orElse(null);
			this.putAmt = ofNullable(builder.getPutAmt()).map(f->f.build()).orElse(null);
			this.prmAmt = ofNullable(builder.getPrmAmt()).map(f->f.build()).orElse(null);
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
		public OptionStyle6Code getExrcStyle() {
			return exrcStyle;
		}
		
		@Override
		@RosettaAttribute("exrcDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exrcDt")
		public ExerciseDate1Choice__1 getExrcDt() {
			return exrcDt;
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
		@RosettaAttribute("callAmt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callAmt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getCallAmt() {
			return callAmt;
		}
		
		@Override
		@RosettaAttribute("putAmt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("putAmt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getPutAmt() {
			return putAmt;
		}
		
		@Override
		@RosettaAttribute("prmAmt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prmAmt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getPrmAmt() {
			return prmAmt;
		}
		
		@Override
		public OptionOrSwaption11__1 build() {
			return this;
		}
		
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder toBuilder() {
			OptionOrSwaption11__1.OptionOrSwaption11__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionOrSwaption11__1.OptionOrSwaption11__1Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
			ofNullable(getExrcStyle()).ifPresent(builder::setExrcStyle);
			ofNullable(getExrcDt()).ifPresent(builder::setExrcDt);
			ofNullable(getStrkPric()).ifPresent(builder::setStrkPric);
			ofNullable(getStrkPricSchdl()).ifPresent(builder::setStrkPricSchdl);
			ofNullable(getCallAmt()).ifPresent(builder::setCallAmt);
			ofNullable(getPutAmt()).ifPresent(builder::setPutAmt);
			ofNullable(getPrmAmt()).ifPresent(builder::setPrmAmt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionOrSwaption11__1 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(exrcStyle, _that.getExrcStyle())) return false;
			if (!Objects.equals(exrcDt, _that.getExrcDt())) return false;
			if (!Objects.equals(strkPric, _that.getStrkPric())) return false;
			if (!ListEquals.listEquals(strkPricSchdl, _that.getStrkPricSchdl())) return false;
			if (!Objects.equals(callAmt, _that.getCallAmt())) return false;
			if (!Objects.equals(putAmt, _that.getPutAmt())) return false;
			if (!Objects.equals(prmAmt, _that.getPrmAmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exrcStyle != null ? exrcStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exrcDt != null ? exrcDt.hashCode() : 0);
			_result = 31 * _result + (strkPric != null ? strkPric.hashCode() : 0);
			_result = 31 * _result + (strkPricSchdl != null ? strkPricSchdl.hashCode() : 0);
			_result = 31 * _result + (callAmt != null ? callAmt.hashCode() : 0);
			_result = 31 * _result + (putAmt != null ? putAmt.hashCode() : 0);
			_result = 31 * _result + (prmAmt != null ? prmAmt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionOrSwaption11__1 {" +
				"tp=" + this.tp + ", " +
				"exrcStyle=" + this.exrcStyle + ", " +
				"exrcDt=" + this.exrcDt + ", " +
				"strkPric=" + this.strkPric + ", " +
				"strkPricSchdl=" + this.strkPricSchdl + ", " +
				"callAmt=" + this.callAmt + ", " +
				"putAmt=" + this.putAmt + ", " +
				"prmAmt=" + this.prmAmt +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionOrSwaption11__1  ***********************/
	class OptionOrSwaption11__1BuilderImpl implements OptionOrSwaption11__1.OptionOrSwaption11__1Builder {
	
		protected OptionType2Code tp;
		protected OptionStyle6Code exrcStyle;
		protected ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder exrcDt;
		protected SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder strkPric;
		protected List<Schedule4__1.Schedule4__1Builder> strkPricSchdl = new ArrayList<>();
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder callAmt;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder putAmt;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder prmAmt;
		
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
		public OptionStyle6Code getExrcStyle() {
			return exrcStyle;
		}
		
		@Override
		@RosettaAttribute("exrcDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exrcDt")
		public ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder getExrcDt() {
			return exrcDt;
		}
		
		@Override
		public ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder getOrCreateExrcDt() {
			ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder result;
			if (exrcDt!=null) {
				result = exrcDt;
			}
			else {
				result = exrcDt = ExerciseDate1Choice__1.builder();
			}
			
			return result;
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
		@RosettaAttribute("callAmt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("callAmt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getCallAmt() {
			return callAmt;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateCallAmt() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (callAmt!=null) {
				result = callAmt;
			}
			else {
				result = callAmt = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("putAmt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("putAmt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getPutAmt() {
			return putAmt;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreatePutAmt() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (putAmt!=null) {
				result = putAmt;
			}
			else {
				result = putAmt = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("prmAmt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("prmAmt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getPrmAmt() {
			return prmAmt;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreatePrmAmt() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (prmAmt!=null) {
				result = prmAmt;
			}
			else {
				result = prmAmt = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tp")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setTp(OptionType2Code _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@RosettaAttribute("exrcStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exrcStyle")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setExrcStyle(OptionStyle6Code _exrcStyle) {
			this.exrcStyle = _exrcStyle == null ? null : _exrcStyle;
			return this;
		}
		
		@RosettaAttribute("exrcDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exrcDt")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setExrcDt(ExerciseDate1Choice__1 _exrcDt) {
			this.exrcDt = _exrcDt == null ? null : _exrcDt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strkPric")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strkPric")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setStrkPric(SecuritiesTransactionPrice17Choice__1 _strkPric) {
			this.strkPric = _strkPric == null ? null : _strkPric.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strkPricSchdl")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("strkPricSchdl")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder addStrkPricSchdl(Schedule4__1 _strkPricSchdl) {
			if (_strkPricSchdl != null) {
				this.strkPricSchdl.add(_strkPricSchdl.toBuilder());
			}
			return this;
		}
		
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder addStrkPricSchdl(Schedule4__1 _strkPricSchdl, int idx) {
			getIndex(this.strkPricSchdl, idx, () -> _strkPricSchdl.toBuilder());
			return this;
		}
		
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder addStrkPricSchdl(List<? extends Schedule4__1> strkPricSchdls) {
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
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setStrkPricSchdl(List<? extends Schedule4__1> strkPricSchdls) {
			if (strkPricSchdls == null) {
				this.strkPricSchdl = new ArrayList<>();
			} else {
				this.strkPricSchdl = strkPricSchdls.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("callAmt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmt")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setCallAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount _callAmt) {
			this.callAmt = _callAmt == null ? null : _callAmt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("putAmt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmt")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setPutAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount _putAmt) {
			this.putAmt = _putAmt == null ? null : _putAmt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prmAmt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prmAmt")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setPrmAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount _prmAmt) {
			this.prmAmt = _prmAmt == null ? null : _prmAmt.toBuilder();
			return this;
		}
		
		@Override
		public OptionOrSwaption11__1 build() {
			return new OptionOrSwaption11__1.OptionOrSwaption11__1Impl(this);
		}
		
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder prune() {
			if (exrcDt!=null && !exrcDt.prune().hasData()) exrcDt = null;
			if (strkPric!=null && !strkPric.prune().hasData()) strkPric = null;
			strkPricSchdl = strkPricSchdl.stream().filter(b->b!=null).<Schedule4__1.Schedule4__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (callAmt!=null && !callAmt.prune().hasData()) callAmt = null;
			if (putAmt!=null && !putAmt.prune().hasData()) putAmt = null;
			if (prmAmt!=null && !prmAmt.prune().hasData()) prmAmt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null) return true;
			if (getExrcStyle()!=null) return true;
			if (getExrcDt()!=null && getExrcDt().hasData()) return true;
			if (getStrkPric()!=null && getStrkPric().hasData()) return true;
			if (getStrkPricSchdl()!=null && getStrkPricSchdl().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCallAmt()!=null && getCallAmt().hasData()) return true;
			if (getPutAmt()!=null && getPutAmt().hasData()) return true;
			if (getPrmAmt()!=null && getPrmAmt().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionOrSwaption11__1.OptionOrSwaption11__1Builder o = (OptionOrSwaption11__1.OptionOrSwaption11__1Builder) other;
			
			merger.mergeRosetta(getExrcDt(), o.getExrcDt(), this::setExrcDt);
			merger.mergeRosetta(getStrkPric(), o.getStrkPric(), this::setStrkPric);
			merger.mergeRosetta(getStrkPricSchdl(), o.getStrkPricSchdl(), this::getOrCreateStrkPricSchdl);
			merger.mergeRosetta(getCallAmt(), o.getCallAmt(), this::setCallAmt);
			merger.mergeRosetta(getPutAmt(), o.getPutAmt(), this::setPutAmt);
			merger.mergeRosetta(getPrmAmt(), o.getPrmAmt(), this::setPrmAmt);
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			merger.mergeBasic(getExrcStyle(), o.getExrcStyle(), this::setExrcStyle);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionOrSwaption11__1 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(exrcStyle, _that.getExrcStyle())) return false;
			if (!Objects.equals(exrcDt, _that.getExrcDt())) return false;
			if (!Objects.equals(strkPric, _that.getStrkPric())) return false;
			if (!ListEquals.listEquals(strkPricSchdl, _that.getStrkPricSchdl())) return false;
			if (!Objects.equals(callAmt, _that.getCallAmt())) return false;
			if (!Objects.equals(putAmt, _that.getPutAmt())) return false;
			if (!Objects.equals(prmAmt, _that.getPrmAmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exrcStyle != null ? exrcStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exrcDt != null ? exrcDt.hashCode() : 0);
			_result = 31 * _result + (strkPric != null ? strkPric.hashCode() : 0);
			_result = 31 * _result + (strkPricSchdl != null ? strkPricSchdl.hashCode() : 0);
			_result = 31 * _result + (callAmt != null ? callAmt.hashCode() : 0);
			_result = 31 * _result + (putAmt != null ? putAmt.hashCode() : 0);
			_result = 31 * _result + (prmAmt != null ? prmAmt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionOrSwaption11__1Builder {" +
				"tp=" + this.tp + ", " +
				"exrcStyle=" + this.exrcStyle + ", " +
				"exrcDt=" + this.exrcDt + ", " +
				"strkPric=" + this.strkPric + ", " +
				"strkPricSchdl=" + this.strkPricSchdl + ", " +
				"callAmt=" + this.callAmt + ", " +
				"putAmt=" + this.putAmt + ", " +
				"prmAmt=" + this.prmAmt +
			'}';
		}
	}
}
