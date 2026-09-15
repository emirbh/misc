package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.OptionOrSwaption11__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionOrSwaption11__1", builder=OptionOrSwaption11__1.OptionOrSwaption11__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="OptionOrSwaption11__1", model="iso20022", builder=OptionOrSwaption11__1.OptionOrSwaption11__1BuilderImpl.class, version="${project.version}")
public interface OptionOrSwaption11__1 extends RosettaModelObject {

	OptionOrSwaption11__1Meta metaData = new OptionOrSwaption11__1Meta();

	/*********************** Getter Methods  ***********************/
	SecuritiesTransactionPrice17Choice__1 getStrkPric();
	ActiveOrHistoricCurrencyAnd5DecimalAmount getCallAmt();
	ActiveOrHistoricCurrencyAnd5DecimalAmount getPutAmt();
	ActiveOrHistoricCurrencyAnd5DecimalAmount getPrmAmt();
	Date getPrmPmtDt();
	Date getMtrtyDtOfUndrlyg();
	OptionBarrierLevel1Choice__1 getBrrrLvls();

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
		processRosetta(path.newSubPath("strkPric"), processor, SecuritiesTransactionPrice17Choice__1.class, getStrkPric());
		processRosetta(path.newSubPath("callAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getCallAmt());
		processRosetta(path.newSubPath("putAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getPutAmt());
		processRosetta(path.newSubPath("prmAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getPrmAmt());
		processor.processBasic(path.newSubPath("prmPmtDt"), Date.class, getPrmPmtDt(), this);
		processor.processBasic(path.newSubPath("mtrtyDtOfUndrlyg"), Date.class, getMtrtyDtOfUndrlyg(), this);
		processRosetta(path.newSubPath("brrrLvls"), processor, OptionBarrierLevel1Choice__1.class, getBrrrLvls());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionOrSwaption11__1Builder extends OptionOrSwaption11__1, RosettaModelObjectBuilder {
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
		OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder getOrCreateBrrrLvls();
		@Override
		OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder getBrrrLvls();
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setStrkPric(SecuritiesTransactionPrice17Choice__1 strkPric);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setCallAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount callAmt);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setPutAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount putAmt);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setPrmAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount prmAmt);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setPrmPmtDt(Date prmPmtDt);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setMtrtyDtOfUndrlyg(Date mtrtyDtOfUndrlyg);
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder setBrrrLvls(OptionBarrierLevel1Choice__1 brrrLvls);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("strkPric"), processor, SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder.class, getStrkPric());
			processRosetta(path.newSubPath("callAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getCallAmt());
			processRosetta(path.newSubPath("putAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getPutAmt());
			processRosetta(path.newSubPath("prmAmt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getPrmAmt());
			processor.processBasic(path.newSubPath("prmPmtDt"), Date.class, getPrmPmtDt(), this);
			processor.processBasic(path.newSubPath("mtrtyDtOfUndrlyg"), Date.class, getMtrtyDtOfUndrlyg(), this);
			processRosetta(path.newSubPath("brrrLvls"), processor, OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder.class, getBrrrLvls());
		}
		

		OptionOrSwaption11__1.OptionOrSwaption11__1Builder prune();
	}

	/*********************** Immutable Implementation of OptionOrSwaption11__1  ***********************/
	class OptionOrSwaption11__1Impl implements OptionOrSwaption11__1 {
		private final SecuritiesTransactionPrice17Choice__1 strkPric;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount callAmt;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount putAmt;
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount prmAmt;
		private final Date prmPmtDt;
		private final Date mtrtyDtOfUndrlyg;
		private final OptionBarrierLevel1Choice__1 brrrLvls;
		
		protected OptionOrSwaption11__1Impl(OptionOrSwaption11__1.OptionOrSwaption11__1Builder builder) {
			this.strkPric = ofNullable(builder.getStrkPric()).map(f->f.build()).orElse(null);
			this.callAmt = ofNullable(builder.getCallAmt()).map(f->f.build()).orElse(null);
			this.putAmt = ofNullable(builder.getPutAmt()).map(f->f.build()).orElse(null);
			this.prmAmt = ofNullable(builder.getPrmAmt()).map(f->f.build()).orElse(null);
			this.prmPmtDt = builder.getPrmPmtDt();
			this.mtrtyDtOfUndrlyg = builder.getMtrtyDtOfUndrlyg();
			this.brrrLvls = ofNullable(builder.getBrrrLvls()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("brrrLvls")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brrrLvls")
		public OptionBarrierLevel1Choice__1 getBrrrLvls() {
			return brrrLvls;
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
			ofNullable(getStrkPric()).ifPresent(builder::setStrkPric);
			ofNullable(getCallAmt()).ifPresent(builder::setCallAmt);
			ofNullable(getPutAmt()).ifPresent(builder::setPutAmt);
			ofNullable(getPrmAmt()).ifPresent(builder::setPrmAmt);
			ofNullable(getPrmPmtDt()).ifPresent(builder::setPrmPmtDt);
			ofNullable(getMtrtyDtOfUndrlyg()).ifPresent(builder::setMtrtyDtOfUndrlyg);
			ofNullable(getBrrrLvls()).ifPresent(builder::setBrrrLvls);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionOrSwaption11__1 _that = getType().cast(o);
		
			if (!Objects.equals(strkPric, _that.getStrkPric())) return false;
			if (!Objects.equals(callAmt, _that.getCallAmt())) return false;
			if (!Objects.equals(putAmt, _that.getPutAmt())) return false;
			if (!Objects.equals(prmAmt, _that.getPrmAmt())) return false;
			if (!Objects.equals(prmPmtDt, _that.getPrmPmtDt())) return false;
			if (!Objects.equals(mtrtyDtOfUndrlyg, _that.getMtrtyDtOfUndrlyg())) return false;
			if (!Objects.equals(brrrLvls, _that.getBrrrLvls())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strkPric != null ? strkPric.hashCode() : 0);
			_result = 31 * _result + (callAmt != null ? callAmt.hashCode() : 0);
			_result = 31 * _result + (putAmt != null ? putAmt.hashCode() : 0);
			_result = 31 * _result + (prmAmt != null ? prmAmt.hashCode() : 0);
			_result = 31 * _result + (prmPmtDt != null ? prmPmtDt.hashCode() : 0);
			_result = 31 * _result + (mtrtyDtOfUndrlyg != null ? mtrtyDtOfUndrlyg.hashCode() : 0);
			_result = 31 * _result + (brrrLvls != null ? brrrLvls.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionOrSwaption11__1 {" +
				"strkPric=" + this.strkPric + ", " +
				"callAmt=" + this.callAmt + ", " +
				"putAmt=" + this.putAmt + ", " +
				"prmAmt=" + this.prmAmt + ", " +
				"prmPmtDt=" + this.prmPmtDt + ", " +
				"mtrtyDtOfUndrlyg=" + this.mtrtyDtOfUndrlyg + ", " +
				"brrrLvls=" + this.brrrLvls +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionOrSwaption11__1  ***********************/
	class OptionOrSwaption11__1BuilderImpl implements OptionOrSwaption11__1.OptionOrSwaption11__1Builder {
	
		protected SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder strkPric;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder callAmt;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder putAmt;
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder prmAmt;
		protected Date prmPmtDt;
		protected Date mtrtyDtOfUndrlyg;
		protected OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder brrrLvls;
		
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
		
		@Override
		@RosettaAttribute("brrrLvls")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brrrLvls")
		public OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder getBrrrLvls() {
			return brrrLvls;
		}
		
		@Override
		public OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder getOrCreateBrrrLvls() {
			OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder result;
			if (brrrLvls!=null) {
				result = brrrLvls;
			}
			else {
				result = brrrLvls = OptionBarrierLevel1Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("strkPric")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strkPric")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setStrkPric(SecuritiesTransactionPrice17Choice__1 _strkPric) {
			this.strkPric = _strkPric == null ? null : _strkPric.toBuilder();
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
		
		@RosettaAttribute("prmPmtDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("prmPmtDt")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setPrmPmtDt(Date _prmPmtDt) {
			this.prmPmtDt = _prmPmtDt == null ? null : _prmPmtDt;
			return this;
		}
		
		@RosettaAttribute("mtrtyDtOfUndrlyg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mtrtyDtOfUndrlyg")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setMtrtyDtOfUndrlyg(Date _mtrtyDtOfUndrlyg) {
			this.mtrtyDtOfUndrlyg = _mtrtyDtOfUndrlyg == null ? null : _mtrtyDtOfUndrlyg;
			return this;
		}
		
		@RosettaAttribute("brrrLvls")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brrrLvls")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder setBrrrLvls(OptionBarrierLevel1Choice__1 _brrrLvls) {
			this.brrrLvls = _brrrLvls == null ? null : _brrrLvls.toBuilder();
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
			if (strkPric!=null && !strkPric.prune().hasData()) strkPric = null;
			if (callAmt!=null && !callAmt.prune().hasData()) callAmt = null;
			if (putAmt!=null && !putAmt.prune().hasData()) putAmt = null;
			if (prmAmt!=null && !prmAmt.prune().hasData()) prmAmt = null;
			if (brrrLvls!=null && !brrrLvls.prune().hasData()) brrrLvls = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStrkPric()!=null && getStrkPric().hasData()) return true;
			if (getCallAmt()!=null && getCallAmt().hasData()) return true;
			if (getPutAmt()!=null && getPutAmt().hasData()) return true;
			if (getPrmAmt()!=null && getPrmAmt().hasData()) return true;
			if (getPrmPmtDt()!=null) return true;
			if (getMtrtyDtOfUndrlyg()!=null) return true;
			if (getBrrrLvls()!=null && getBrrrLvls().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionOrSwaption11__1.OptionOrSwaption11__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionOrSwaption11__1.OptionOrSwaption11__1Builder o = (OptionOrSwaption11__1.OptionOrSwaption11__1Builder) other;
			
			merger.mergeRosetta(getStrkPric(), o.getStrkPric(), this::setStrkPric);
			merger.mergeRosetta(getCallAmt(), o.getCallAmt(), this::setCallAmt);
			merger.mergeRosetta(getPutAmt(), o.getPutAmt(), this::setPutAmt);
			merger.mergeRosetta(getPrmAmt(), o.getPrmAmt(), this::setPrmAmt);
			merger.mergeRosetta(getBrrrLvls(), o.getBrrrLvls(), this::setBrrrLvls);
			
			merger.mergeBasic(getPrmPmtDt(), o.getPrmPmtDt(), this::setPrmPmtDt);
			merger.mergeBasic(getMtrtyDtOfUndrlyg(), o.getMtrtyDtOfUndrlyg(), this::setMtrtyDtOfUndrlyg);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionOrSwaption11__1 _that = getType().cast(o);
		
			if (!Objects.equals(strkPric, _that.getStrkPric())) return false;
			if (!Objects.equals(callAmt, _that.getCallAmt())) return false;
			if (!Objects.equals(putAmt, _that.getPutAmt())) return false;
			if (!Objects.equals(prmAmt, _that.getPrmAmt())) return false;
			if (!Objects.equals(prmPmtDt, _that.getPrmPmtDt())) return false;
			if (!Objects.equals(mtrtyDtOfUndrlyg, _that.getMtrtyDtOfUndrlyg())) return false;
			if (!Objects.equals(brrrLvls, _that.getBrrrLvls())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (strkPric != null ? strkPric.hashCode() : 0);
			_result = 31 * _result + (callAmt != null ? callAmt.hashCode() : 0);
			_result = 31 * _result + (putAmt != null ? putAmt.hashCode() : 0);
			_result = 31 * _result + (prmAmt != null ? prmAmt.hashCode() : 0);
			_result = 31 * _result + (prmPmtDt != null ? prmPmtDt.hashCode() : 0);
			_result = 31 * _result + (mtrtyDtOfUndrlyg != null ? mtrtyDtOfUndrlyg.hashCode() : 0);
			_result = 31 * _result + (brrrLvls != null ? brrrLvls.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionOrSwaption11__1Builder {" +
				"strkPric=" + this.strkPric + ", " +
				"callAmt=" + this.callAmt + ", " +
				"putAmt=" + this.putAmt + ", " +
				"prmAmt=" + this.prmAmt + ", " +
				"prmPmtDt=" + this.prmPmtDt + ", " +
				"mtrtyDtOfUndrlyg=" + this.mtrtyDtOfUndrlyg + ", " +
				"brrrLvls=" + this.brrrLvls +
			'}';
		}
	}
}
