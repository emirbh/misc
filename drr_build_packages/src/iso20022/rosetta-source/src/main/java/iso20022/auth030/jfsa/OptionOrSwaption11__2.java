package iso20022.auth030.jfsa;

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
import com.rosetta.model.lib.records.Date;
import iso20022.auth030.jfsa.meta.OptionOrSwaption11__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionOrSwaption11__2", builder=OptionOrSwaption11__2.OptionOrSwaption11__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OptionOrSwaption11__2", model="iso20022", builder=OptionOrSwaption11__2.OptionOrSwaption11__2BuilderImpl.class, version="${project.version}")
public interface OptionOrSwaption11__2 extends RosettaModelObject {

	OptionOrSwaption11__2Meta metaData = new OptionOrSwaption11__2Meta();

	/*********************** Getter Methods  ***********************/
	OptionType2Code getTp();
	EmbeddedType1Code getMbddTp();
	OptionStyle6Code getExrcStyle();
	ExerciseDate1Choice__1 getExrcDt();
	SecuritiesTransactionPrice17Choice__1 getStrkPric();
	ActiveOrHistoricCurrencyAnd5DecimalAmount getCallAmt();
	ActiveOrHistoricCurrencyAnd5DecimalAmount getPutAmt();
	ActiveOrHistoricCurrencyAnd5DecimalAmount getPrmAmt();
	Date getPrmPmtDt();
	Date getMtrtyDtOfUndrlyg();

	/*********************** Build Methods  ***********************/
	OptionOrSwaption11__2 build();
	
	OptionOrSwaption11__2.OptionOrSwaption11__2Builder toBuilder();
	
	static OptionOrSwaption11__2.OptionOrSwaption11__2Builder builder() {
		return new OptionOrSwaption11__2.OptionOrSwaption11__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionOrSwaption11__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OptionOrSwaption11__2> getType() {
		return OptionOrSwaption11__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), OptionType2Code.class, getTp(), this);
		processor.processBasic(path.newSubPath("mbddTp"), EmbeddedType1Code.class, getMbddTp(), this);
		processor.processBasic(path.newSubPath("exrcStyle"), OptionStyle6Code.class, getExrcStyle(), this);
		processRosetta(path.newSubPath("exrcDt"), processor, ExerciseDate1Choice__1.class, getExrcDt());
		processRosetta(path.newSubPath("strkPric"), processor, SecuritiesTransactionPrice17Choice__1.class, getStrkPric());
		processRosetta(path.newSubPath("callAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getCallAmt());
		processRosetta(path.newSubPath("putAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getPutAmt());
		processRosetta(path.newSubPath("prmAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getPrmAmt());
		processor.processBasic(path.newSubPath("prmPmtDt"), Date.class, getPrmPmtDt(), this);
		processor.processBasic(path.newSubPath("mtrtyDtOfUndrlyg"), Date.class, getMtrtyDtOfUndrlyg(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionOrSwaption11__2Builder extends OptionOrSwaption11__2, RosettaModelObjectBuilder {
		ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder getOrCreateExrcDt();
		@Override
		ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder getExrcDt();
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getOrCreateStrkPric();
		@Override
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder getStrkPric();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateCallAmt();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getCallAmt();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreatePutAmt();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getPutAmt();
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreatePrmAmt();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getPrmAmt();
		OptionOrSwaption11__2.OptionOrSwaption11__2Builder setTp(OptionType2Code tp);
		OptionOrSwaption11__2.OptionOrSwaption11__2Builder setMbddTp(EmbeddedType1Code mbddTp);
		OptionOrSwaption11__2.OptionOrSwaption11__2Builder setExrcStyle(OptionStyle6Code exrcStyle);
		OptionOrSwaption11__2.OptionOrSwaption11__2Builder setExrcDt(ExerciseDate1Choice__1 exrcDt);
		OptionOrSwaption11__2.OptionOrSwaption11__2Builder setStrkPric(SecuritiesTransactionPrice17Choice__1 strkPric);
		OptionOrSwaption11__2.OptionOrSwaption11__2Builder setCallAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount callAmt);
		OptionOrSwaption11__2.OptionOrSwaption11__2Builder setPutAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount putAmt);
		OptionOrSwaption11__2.OptionOrSwaption11__2Builder setPrmAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount prmAmt);
		OptionOrSwaption11__2.OptionOrSwaption11__2Builder setPrmPmtDt(Date prmPmtDt);
		OptionOrSwaption11__2.OptionOrSwaption11__2Builder setMtrtyDtOfUndrlyg(Date mtrtyDtOfUndrlyg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), OptionType2Code.class, getTp(), this);
			processor.processBasic(path.newSubPath("mbddTp"), EmbeddedType1Code.class, getMbddTp(), this);
			processor.processBasic(path.newSubPath("exrcStyle"), OptionStyle6Code.class, getExrcStyle(), this);
			processRosetta(path.newSubPath("exrcDt"), processor, ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder.class, getExrcDt());
			processRosetta(path.newSubPath("strkPric"), processor, SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder.class, getStrkPric());
			processRosetta(path.newSubPath("callAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getCallAmt());
			processRosetta(path.newSubPath("putAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getPutAmt());
			processRosetta(path.newSubPath("prmAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getPrmAmt());
			processor.processBasic(path.newSubPath("prmPmtDt"), Date.class, getPrmPmtDt(), this);
			processor.processBasic(path.newSubPath("mtrtyDtOfUndrlyg"), Date.class, getMtrtyDtOfUndrlyg(), this);
		}
		

		OptionOrSwaption11__2.OptionOrSwaption11__2Builder prune();
	}

	/*********************** Immutable Implementation of OptionOrSwaption11__2  ***********************/
	class OptionOrSwaption11__2Impl implements OptionOrSwaption11__2 {
		private final OptionType2Code tp;
		private final EmbeddedType1Code mbddTp;
		private final OptionStyle6Code exrcStyle;
		private final ExerciseDate1Choice__1 exrcDt;
		private final SecuritiesTransactionPrice17Choice__1 strkPric;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount callAmt;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount putAmt;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount prmAmt;
		private final Date prmPmtDt;
		private final Date mtrtyDtOfUndrlyg;
		
		protected OptionOrSwaption11__2Impl(OptionOrSwaption11__2.OptionOrSwaption11__2Builder builder) {
			this.tp = builder.getTp();
			this.mbddTp = builder.getMbddTp();
			this.exrcStyle = builder.getExrcStyle();
			this.exrcDt = ofNullable(builder.getExrcDt()).map(f->f.build()).orElse(null);
			this.strkPric = ofNullable(builder.getStrkPric()).map(f->f.build()).orElse(null);
			this.callAmt = ofNullable(builder.getCallAmt()).map(f->f.build()).orElse(null);
			this.putAmt = ofNullable(builder.getPutAmt()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("mbddTp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mbddTp")
		public EmbeddedType1Code getMbddTp() {
			return mbddTp;
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
		public OptionOrSwaption11__2 build() {
			return this;
		}
		
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder toBuilder() {
			OptionOrSwaption11__2.OptionOrSwaption11__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionOrSwaption11__2.OptionOrSwaption11__2Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
			ofNullable(getMbddTp()).ifPresent(builder::setMbddTp);
			ofNullable(getExrcStyle()).ifPresent(builder::setExrcStyle);
			ofNullable(getExrcDt()).ifPresent(builder::setExrcDt);
			ofNullable(getStrkPric()).ifPresent(builder::setStrkPric);
			ofNullable(getCallAmt()).ifPresent(builder::setCallAmt);
			ofNullable(getPutAmt()).ifPresent(builder::setPutAmt);
			ofNullable(getPrmAmt()).ifPresent(builder::setPrmAmt);
			ofNullable(getPrmPmtDt()).ifPresent(builder::setPrmPmtDt);
			ofNullable(getMtrtyDtOfUndrlyg()).ifPresent(builder::setMtrtyDtOfUndrlyg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionOrSwaption11__2 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(mbddTp, _that.getMbddTp())) return false;
			if (!Objects.equals(exrcStyle, _that.getExrcStyle())) return false;
			if (!Objects.equals(exrcDt, _that.getExrcDt())) return false;
			if (!Objects.equals(strkPric, _that.getStrkPric())) return false;
			if (!Objects.equals(callAmt, _that.getCallAmt())) return false;
			if (!Objects.equals(putAmt, _that.getPutAmt())) return false;
			if (!Objects.equals(prmAmt, _that.getPrmAmt())) return false;
			if (!Objects.equals(prmPmtDt, _that.getPrmPmtDt())) return false;
			if (!Objects.equals(mtrtyDtOfUndrlyg, _that.getMtrtyDtOfUndrlyg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (mbddTp != null ? mbddTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exrcStyle != null ? exrcStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exrcDt != null ? exrcDt.hashCode() : 0);
			_result = 31 * _result + (strkPric != null ? strkPric.hashCode() : 0);
			_result = 31 * _result + (callAmt != null ? callAmt.hashCode() : 0);
			_result = 31 * _result + (putAmt != null ? putAmt.hashCode() : 0);
			_result = 31 * _result + (prmAmt != null ? prmAmt.hashCode() : 0);
			_result = 31 * _result + (prmPmtDt != null ? prmPmtDt.hashCode() : 0);
			_result = 31 * _result + (mtrtyDtOfUndrlyg != null ? mtrtyDtOfUndrlyg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionOrSwaption11__2 {" +
				"tp=" + this.tp + ", " +
				"mbddTp=" + this.mbddTp + ", " +
				"exrcStyle=" + this.exrcStyle + ", " +
				"exrcDt=" + this.exrcDt + ", " +
				"strkPric=" + this.strkPric + ", " +
				"callAmt=" + this.callAmt + ", " +
				"putAmt=" + this.putAmt + ", " +
				"prmAmt=" + this.prmAmt + ", " +
				"prmPmtDt=" + this.prmPmtDt + ", " +
				"mtrtyDtOfUndrlyg=" + this.mtrtyDtOfUndrlyg +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionOrSwaption11__2  ***********************/
	class OptionOrSwaption11__2BuilderImpl implements OptionOrSwaption11__2.OptionOrSwaption11__2Builder {
	
		protected OptionType2Code tp;
		protected EmbeddedType1Code mbddTp;
		protected OptionStyle6Code exrcStyle;
		protected ExerciseDate1Choice__1.ExerciseDate1Choice__1Builder exrcDt;
		protected SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder strkPric;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder callAmt;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder putAmt;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder prmAmt;
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
		@RosettaAttribute("mbddTp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mbddTp")
		public EmbeddedType1Code getMbddTp() {
			return mbddTp;
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
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder setTp(OptionType2Code _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@RosettaAttribute("mbddTp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mbddTp")
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder setMbddTp(EmbeddedType1Code _mbddTp) {
			this.mbddTp = _mbddTp == null ? null : _mbddTp;
			return this;
		}
		
		@RosettaAttribute("exrcStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exrcStyle")
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder setExrcStyle(OptionStyle6Code _exrcStyle) {
			this.exrcStyle = _exrcStyle == null ? null : _exrcStyle;
			return this;
		}
		
		@RosettaAttribute("exrcDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exrcDt")
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder setExrcDt(ExerciseDate1Choice__1 _exrcDt) {
			this.exrcDt = _exrcDt == null ? null : _exrcDt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strkPric")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strkPric")
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder setStrkPric(SecuritiesTransactionPrice17Choice__1 _strkPric) {
			this.strkPric = _strkPric == null ? null : _strkPric.toBuilder();
			return this;
		}
		
		@RosettaAttribute("callAmt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("callAmt")
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder setCallAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount _callAmt) {
			this.callAmt = _callAmt == null ? null : _callAmt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("putAmt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("putAmt")
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder setPutAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount _putAmt) {
			this.putAmt = _putAmt == null ? null : _putAmt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prmAmt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prmAmt")
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder setPrmAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount _prmAmt) {
			this.prmAmt = _prmAmt == null ? null : _prmAmt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("prmPmtDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prmPmtDt")
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder setPrmPmtDt(Date _prmPmtDt) {
			this.prmPmtDt = _prmPmtDt == null ? null : _prmPmtDt;
			return this;
		}
		
		@RosettaAttribute("mtrtyDtOfUndrlyg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mtrtyDtOfUndrlyg")
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder setMtrtyDtOfUndrlyg(Date _mtrtyDtOfUndrlyg) {
			this.mtrtyDtOfUndrlyg = _mtrtyDtOfUndrlyg == null ? null : _mtrtyDtOfUndrlyg;
			return this;
		}
		
		@Override
		public OptionOrSwaption11__2 build() {
			return new OptionOrSwaption11__2.OptionOrSwaption11__2Impl(this);
		}
		
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder prune() {
			if (exrcDt!=null && !exrcDt.prune().hasData()) exrcDt = null;
			if (strkPric!=null && !strkPric.prune().hasData()) strkPric = null;
			if (callAmt!=null && !callAmt.prune().hasData()) callAmt = null;
			if (putAmt!=null && !putAmt.prune().hasData()) putAmt = null;
			if (prmAmt!=null && !prmAmt.prune().hasData()) prmAmt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null) return true;
			if (getMbddTp()!=null) return true;
			if (getExrcStyle()!=null) return true;
			if (getExrcDt()!=null && getExrcDt().hasData()) return true;
			if (getStrkPric()!=null && getStrkPric().hasData()) return true;
			if (getCallAmt()!=null && getCallAmt().hasData()) return true;
			if (getPutAmt()!=null && getPutAmt().hasData()) return true;
			if (getPrmAmt()!=null && getPrmAmt().hasData()) return true;
			if (getPrmPmtDt()!=null) return true;
			if (getMtrtyDtOfUndrlyg()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionOrSwaption11__2.OptionOrSwaption11__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionOrSwaption11__2.OptionOrSwaption11__2Builder o = (OptionOrSwaption11__2.OptionOrSwaption11__2Builder) other;
			
			merger.mergeRosetta(getExrcDt(), o.getExrcDt(), this::setExrcDt);
			merger.mergeRosetta(getStrkPric(), o.getStrkPric(), this::setStrkPric);
			merger.mergeRosetta(getCallAmt(), o.getCallAmt(), this::setCallAmt);
			merger.mergeRosetta(getPutAmt(), o.getPutAmt(), this::setPutAmt);
			merger.mergeRosetta(getPrmAmt(), o.getPrmAmt(), this::setPrmAmt);
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			merger.mergeBasic(getMbddTp(), o.getMbddTp(), this::setMbddTp);
			merger.mergeBasic(getExrcStyle(), o.getExrcStyle(), this::setExrcStyle);
			merger.mergeBasic(getPrmPmtDt(), o.getPrmPmtDt(), this::setPrmPmtDt);
			merger.mergeBasic(getMtrtyDtOfUndrlyg(), o.getMtrtyDtOfUndrlyg(), this::setMtrtyDtOfUndrlyg);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionOrSwaption11__2 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(mbddTp, _that.getMbddTp())) return false;
			if (!Objects.equals(exrcStyle, _that.getExrcStyle())) return false;
			if (!Objects.equals(exrcDt, _that.getExrcDt())) return false;
			if (!Objects.equals(strkPric, _that.getStrkPric())) return false;
			if (!Objects.equals(callAmt, _that.getCallAmt())) return false;
			if (!Objects.equals(putAmt, _that.getPutAmt())) return false;
			if (!Objects.equals(prmAmt, _that.getPrmAmt())) return false;
			if (!Objects.equals(prmPmtDt, _that.getPrmPmtDt())) return false;
			if (!Objects.equals(mtrtyDtOfUndrlyg, _that.getMtrtyDtOfUndrlyg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (mbddTp != null ? mbddTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exrcStyle != null ? exrcStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (exrcDt != null ? exrcDt.hashCode() : 0);
			_result = 31 * _result + (strkPric != null ? strkPric.hashCode() : 0);
			_result = 31 * _result + (callAmt != null ? callAmt.hashCode() : 0);
			_result = 31 * _result + (putAmt != null ? putAmt.hashCode() : 0);
			_result = 31 * _result + (prmAmt != null ? prmAmt.hashCode() : 0);
			_result = 31 * _result + (prmPmtDt != null ? prmPmtDt.hashCode() : 0);
			_result = 31 * _result + (mtrtyDtOfUndrlyg != null ? mtrtyDtOfUndrlyg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionOrSwaption11__2Builder {" +
				"tp=" + this.tp + ", " +
				"mbddTp=" + this.mbddTp + ", " +
				"exrcStyle=" + this.exrcStyle + ", " +
				"exrcDt=" + this.exrcDt + ", " +
				"strkPric=" + this.strkPric + ", " +
				"callAmt=" + this.callAmt + ", " +
				"putAmt=" + this.putAmt + ", " +
				"prmAmt=" + this.prmAmt + ", " +
				"prmPmtDt=" + this.prmPmtDt + ", " +
				"mtrtyDtOfUndrlyg=" + this.mtrtyDtOfUndrlyg +
			'}';
		}
	}
}
