package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.SecuritiesTransactionPrice17ChoiceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice to define the price of the securities transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="SecuritiesTransactionPrice17Choice", builder=SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="SecuritiesTransactionPrice17Choice", model="iso20022", builder=SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilderImpl.class, version="${project.version}")
public interface SecuritiesTransactionPrice17Choice extends RosettaModelObject {

	SecuritiesTransactionPrice17ChoiceMeta metaData = new SecuritiesTransactionPrice17ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates that price is expressed as a monetary value.
	 */
	AmountAndDirection106 getMntryVal();
	/**
	 * Indicates that price is expressed in units.
	 */
	BigDecimal getUnit();
	/**
	 * Indicates that price is expressed as a rate, that is a percentage.
	 */
	BigDecimal getPctg();
	/**
	 * Indicates that price is expressed as a yield.
	 */
	BigDecimal getYld();
	BigDecimal getDcml();
	/**
	 * Indicates that price is currently not available, but pending.
	 */
	PriceStatus1Code getPdgPric();
	/**
	 * Indicates that price or quantity is expressed in another notation.
	 */
	SecuritiesTransactionPrice5 getOthr();

	/*********************** Build Methods  ***********************/
	SecuritiesTransactionPrice17Choice build();
	
	SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder toBuilder();
	
	static SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder builder() {
		return new SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SecuritiesTransactionPrice17Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SecuritiesTransactionPrice17Choice> getType() {
		return SecuritiesTransactionPrice17Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mntryVal"), processor, AmountAndDirection106.class, getMntryVal());
		processor.processBasic(path.newSubPath("unit"), BigDecimal.class, getUnit(), this);
		processor.processBasic(path.newSubPath("pctg"), BigDecimal.class, getPctg(), this);
		processor.processBasic(path.newSubPath("yld"), BigDecimal.class, getYld(), this);
		processor.processBasic(path.newSubPath("dcml"), BigDecimal.class, getDcml(), this);
		processor.processBasic(path.newSubPath("pdgPric"), PriceStatus1Code.class, getPdgPric(), this);
		processRosetta(path.newSubPath("othr"), processor, SecuritiesTransactionPrice5.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SecuritiesTransactionPrice17ChoiceBuilder extends SecuritiesTransactionPrice17Choice, RosettaModelObjectBuilder {
		AmountAndDirection106.AmountAndDirection106Builder getOrCreateMntryVal();
		@Override
		AmountAndDirection106.AmountAndDirection106Builder getMntryVal();
		SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder getOrCreateOthr();
		@Override
		SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder getOthr();
		SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setMntryVal(AmountAndDirection106 mntryVal);
		SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setUnit(BigDecimal unit);
		SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setPctg(BigDecimal pctg);
		SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setYld(BigDecimal yld);
		SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setDcml(BigDecimal dcml);
		SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setPdgPric(PriceStatus1Code pdgPric);
		SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setOthr(SecuritiesTransactionPrice5 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mntryVal"), processor, AmountAndDirection106.AmountAndDirection106Builder.class, getMntryVal());
			processor.processBasic(path.newSubPath("unit"), BigDecimal.class, getUnit(), this);
			processor.processBasic(path.newSubPath("pctg"), BigDecimal.class, getPctg(), this);
			processor.processBasic(path.newSubPath("yld"), BigDecimal.class, getYld(), this);
			processor.processBasic(path.newSubPath("dcml"), BigDecimal.class, getDcml(), this);
			processor.processBasic(path.newSubPath("pdgPric"), PriceStatus1Code.class, getPdgPric(), this);
			processRosetta(path.newSubPath("othr"), processor, SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder.class, getOthr());
		}
		

		SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of SecuritiesTransactionPrice17Choice  ***********************/
	class SecuritiesTransactionPrice17ChoiceImpl implements SecuritiesTransactionPrice17Choice {
		private final AmountAndDirection106 mntryVal;
		private final BigDecimal unit;
		private final BigDecimal pctg;
		private final BigDecimal yld;
		private final BigDecimal dcml;
		private final PriceStatus1Code pdgPric;
		private final SecuritiesTransactionPrice5 othr;
		
		protected SecuritiesTransactionPrice17ChoiceImpl(SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder builder) {
			this.mntryVal = ofNullable(builder.getMntryVal()).map(f->f.build()).orElse(null);
			this.unit = builder.getUnit();
			this.pctg = builder.getPctg();
			this.yld = builder.getYld();
			this.dcml = builder.getDcml();
			this.pdgPric = builder.getPdgPric();
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mntryVal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mntryVal")
		public AmountAndDirection106 getMntryVal() {
			return mntryVal;
		}
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unit")
		public BigDecimal getUnit() {
			return unit;
		}
		
		@Override
		@RosettaAttribute("pctg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pctg")
		public BigDecimal getPctg() {
			return pctg;
		}
		
		@Override
		@RosettaAttribute("yld")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("yld")
		public BigDecimal getYld() {
			return yld;
		}
		
		@Override
		@RosettaAttribute("dcml")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dcml")
		public BigDecimal getDcml() {
			return dcml;
		}
		
		@Override
		@RosettaAttribute("pdgPric")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pdgPric")
		public PriceStatus1Code getPdgPric() {
			return pdgPric;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public SecuritiesTransactionPrice5 getOthr() {
			return othr;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice build() {
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder toBuilder() {
			SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder builder) {
			ofNullable(getMntryVal()).ifPresent(builder::setMntryVal);
			ofNullable(getUnit()).ifPresent(builder::setUnit);
			ofNullable(getPctg()).ifPresent(builder::setPctg);
			ofNullable(getYld()).ifPresent(builder::setYld);
			ofNullable(getDcml()).ifPresent(builder::setDcml);
			ofNullable(getPdgPric()).ifPresent(builder::setPdgPric);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice17Choice _that = getType().cast(o);
		
			if (!Objects.equals(mntryVal, _that.getMntryVal())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(pctg, _that.getPctg())) return false;
			if (!Objects.equals(yld, _that.getYld())) return false;
			if (!Objects.equals(dcml, _that.getDcml())) return false;
			if (!Objects.equals(pdgPric, _that.getPdgPric())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mntryVal != null ? mntryVal.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (pctg != null ? pctg.hashCode() : 0);
			_result = 31 * _result + (yld != null ? yld.hashCode() : 0);
			_result = 31 * _result + (dcml != null ? dcml.hashCode() : 0);
			_result = 31 * _result + (pdgPric != null ? pdgPric.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice17Choice {" +
				"mntryVal=" + this.mntryVal + ", " +
				"unit=" + this.unit + ", " +
				"pctg=" + this.pctg + ", " +
				"yld=" + this.yld + ", " +
				"dcml=" + this.dcml + ", " +
				"pdgPric=" + this.pdgPric + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of SecuritiesTransactionPrice17Choice  ***********************/
	class SecuritiesTransactionPrice17ChoiceBuilderImpl implements SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder {
	
		protected AmountAndDirection106.AmountAndDirection106Builder mntryVal;
		protected BigDecimal unit;
		protected BigDecimal pctg;
		protected BigDecimal yld;
		protected BigDecimal dcml;
		protected PriceStatus1Code pdgPric;
		protected SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder othr;
		
		@Override
		@RosettaAttribute("mntryVal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mntryVal")
		public AmountAndDirection106.AmountAndDirection106Builder getMntryVal() {
			return mntryVal;
		}
		
		@Override
		public AmountAndDirection106.AmountAndDirection106Builder getOrCreateMntryVal() {
			AmountAndDirection106.AmountAndDirection106Builder result;
			if (mntryVal!=null) {
				result = mntryVal;
			}
			else {
				result = mntryVal = AmountAndDirection106.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unit")
		public BigDecimal getUnit() {
			return unit;
		}
		
		@Override
		@RosettaAttribute("pctg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pctg")
		public BigDecimal getPctg() {
			return pctg;
		}
		
		@Override
		@RosettaAttribute("yld")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("yld")
		public BigDecimal getYld() {
			return yld;
		}
		
		@Override
		@RosettaAttribute("dcml")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dcml")
		public BigDecimal getDcml() {
			return dcml;
		}
		
		@Override
		@RosettaAttribute("pdgPric")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pdgPric")
		public PriceStatus1Code getPdgPric() {
			return pdgPric;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder getOthr() {
			return othr;
		}
		
		@Override
		public SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder getOrCreateOthr() {
			SecuritiesTransactionPrice5.SecuritiesTransactionPrice5Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = SecuritiesTransactionPrice5.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("mntryVal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mntryVal")
		@Override
		public SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setMntryVal(AmountAndDirection106 _mntryVal) {
			this.mntryVal = _mntryVal == null ? null : _mntryVal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("unit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unit")
		@Override
		public SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setUnit(BigDecimal _unit) {
			this.unit = _unit == null ? null : _unit;
			return this;
		}
		
		@RosettaAttribute("pctg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pctg")
		@Override
		public SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setPctg(BigDecimal _pctg) {
			this.pctg = _pctg == null ? null : _pctg;
			return this;
		}
		
		@RosettaAttribute("yld")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("yld")
		@Override
		public SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setYld(BigDecimal _yld) {
			this.yld = _yld == null ? null : _yld;
			return this;
		}
		
		@RosettaAttribute("dcml")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dcml")
		@Override
		public SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setDcml(BigDecimal _dcml) {
			this.dcml = _dcml == null ? null : _dcml;
			return this;
		}
		
		@RosettaAttribute("pdgPric")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pdgPric")
		@Override
		public SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setPdgPric(PriceStatus1Code _pdgPric) {
			this.pdgPric = _pdgPric == null ? null : _pdgPric;
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder setOthr(SecuritiesTransactionPrice5 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice build() {
			return new SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceImpl(this);
		}
		
		@Override
		public SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder prune() {
			if (mntryVal!=null && !mntryVal.prune().hasData()) mntryVal = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMntryVal()!=null && getMntryVal().hasData()) return true;
			if (getUnit()!=null) return true;
			if (getPctg()!=null) return true;
			if (getYld()!=null) return true;
			if (getDcml()!=null) return true;
			if (getPdgPric()!=null) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder o = (SecuritiesTransactionPrice17Choice.SecuritiesTransactionPrice17ChoiceBuilder) other;
			
			merger.mergeRosetta(getMntryVal(), o.getMntryVal(), this::setMntryVal);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			merger.mergeBasic(getUnit(), o.getUnit(), this::setUnit);
			merger.mergeBasic(getPctg(), o.getPctg(), this::setPctg);
			merger.mergeBasic(getYld(), o.getYld(), this::setYld);
			merger.mergeBasic(getDcml(), o.getDcml(), this::setDcml);
			merger.mergeBasic(getPdgPric(), o.getPdgPric(), this::setPdgPric);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuritiesTransactionPrice17Choice _that = getType().cast(o);
		
			if (!Objects.equals(mntryVal, _that.getMntryVal())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(pctg, _that.getPctg())) return false;
			if (!Objects.equals(yld, _that.getYld())) return false;
			if (!Objects.equals(dcml, _that.getDcml())) return false;
			if (!Objects.equals(pdgPric, _that.getPdgPric())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mntryVal != null ? mntryVal.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (pctg != null ? pctg.hashCode() : 0);
			_result = 31 * _result + (yld != null ? yld.hashCode() : 0);
			_result = 31 * _result + (dcml != null ? dcml.hashCode() : 0);
			_result = 31 * _result + (pdgPric != null ? pdgPric.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuritiesTransactionPrice17ChoiceBuilder {" +
				"mntryVal=" + this.mntryVal + ", " +
				"unit=" + this.unit + ", " +
				"pctg=" + this.pctg + ", " +
				"yld=" + this.yld + ", " +
				"dcml=" + this.dcml + ", " +
				"pdgPric=" + this.pdgPric + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
