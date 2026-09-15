package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.FloatingRate13__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Floating rate related information.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRate13__1", builder=FloatingRate13__1.FloatingRate13__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FloatingRate13__1", model="iso20022", builder=FloatingRate13__1.FloatingRate13__1BuilderImpl.class, version="${project.version}")
public interface FloatingRate13__1 extends RosettaModelObject {

	FloatingRate13__1Meta metaData = new FloatingRate13__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifier of the security subject of the transaction
	 */
	String getId();
	/**
	 * The full name of the interest rate as assigned by the index provider.
	 */
	String getNm();
	/**
	 * Indication of the floating rate used.
	 */
	FloatingRateIdentification8Choice__1 getRate();
	/**
	 * Information related to reference period.
	 */
	InterestRateContractTerm4__1 getRefPrd();
	/**
	 * Indicates a margin, over or under an index, which determines a price or a rate for each leg of a derivative transaction with periodic payments; or a difference between two floating leg indexes.
	 */
	SecuritiesTransactionPrice20Choice__1 getSprd();
	/**
	 * Identifies the computation method that determines how interest payments are calculated. It is used to compute the year fraction of the calculation period, and indicates the number of days in the calculation period divided by the number of days in the year.
	 */
	InterestComputationMethodFormat7__1 getDayCnt();
	/**
	 * Specifies the time unit associated with the frequency of payments.
	 */
	InterestRateFrequency3Choice__1 getPmtFrqcy();

	/*********************** Build Methods  ***********************/
	FloatingRate13__1 build();
	
	FloatingRate13__1.FloatingRate13__1Builder toBuilder();
	
	static FloatingRate13__1.FloatingRate13__1Builder builder() {
		return new FloatingRate13__1.FloatingRate13__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRate13__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRate13__1> getType() {
		return FloatingRate13__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("nm"), String.class, getNm(), this);
		processRosetta(path.newSubPath("rate"), processor, FloatingRateIdentification8Choice__1.class, getRate());
		processRosetta(path.newSubPath("refPrd"), processor, InterestRateContractTerm4__1.class, getRefPrd());
		processRosetta(path.newSubPath("sprd"), processor, SecuritiesTransactionPrice20Choice__1.class, getSprd());
		processRosetta(path.newSubPath("dayCnt"), processor, InterestComputationMethodFormat7__1.class, getDayCnt());
		processRosetta(path.newSubPath("pmtFrqcy"), processor, InterestRateFrequency3Choice__1.class, getPmtFrqcy());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRate13__1Builder extends FloatingRate13__1, RosettaModelObjectBuilder {
		FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder getOrCreateRate();
		@Override
		FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder getRate();
		InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder getOrCreateRefPrd();
		@Override
		InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder getRefPrd();
		SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getOrCreateSprd();
		@Override
		SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getSprd();
		InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder getOrCreateDayCnt();
		@Override
		InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder getDayCnt();
		InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder getOrCreatePmtFrqcy();
		@Override
		InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder getPmtFrqcy();
		FloatingRate13__1.FloatingRate13__1Builder setId(String id);
		FloatingRate13__1.FloatingRate13__1Builder setNm(String nm);
		FloatingRate13__1.FloatingRate13__1Builder setRate(FloatingRateIdentification8Choice__1 rate);
		FloatingRate13__1.FloatingRate13__1Builder setRefPrd(InterestRateContractTerm4__1 refPrd);
		FloatingRate13__1.FloatingRate13__1Builder setSprd(SecuritiesTransactionPrice20Choice__1 sprd);
		FloatingRate13__1.FloatingRate13__1Builder setDayCnt(InterestComputationMethodFormat7__1 dayCnt);
		FloatingRate13__1.FloatingRate13__1Builder setPmtFrqcy(InterestRateFrequency3Choice__1 pmtFrqcy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("nm"), String.class, getNm(), this);
			processRosetta(path.newSubPath("rate"), processor, FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder.class, getRate());
			processRosetta(path.newSubPath("refPrd"), processor, InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder.class, getRefPrd());
			processRosetta(path.newSubPath("sprd"), processor, SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder.class, getSprd());
			processRosetta(path.newSubPath("dayCnt"), processor, InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder.class, getDayCnt());
			processRosetta(path.newSubPath("pmtFrqcy"), processor, InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder.class, getPmtFrqcy());
		}
		

		FloatingRate13__1.FloatingRate13__1Builder prune();
	}

	/*********************** Immutable Implementation of FloatingRate13__1  ***********************/
	class FloatingRate13__1Impl implements FloatingRate13__1 {
		private final String id;
		private final String nm;
		private final FloatingRateIdentification8Choice__1 rate;
		private final InterestRateContractTerm4__1 refPrd;
		private final SecuritiesTransactionPrice20Choice__1 sprd;
		private final InterestComputationMethodFormat7__1 dayCnt;
		private final InterestRateFrequency3Choice__1 pmtFrqcy;
		
		protected FloatingRate13__1Impl(FloatingRate13__1.FloatingRate13__1Builder builder) {
			this.id = builder.getId();
			this.nm = builder.getNm();
			this.rate = ofNullable(builder.getRate()).map(f->f.build()).orElse(null);
			this.refPrd = ofNullable(builder.getRefPrd()).map(f->f.build()).orElse(null);
			this.sprd = ofNullable(builder.getSprd()).map(f->f.build()).orElse(null);
			this.dayCnt = ofNullable(builder.getDayCnt()).map(f->f.build()).orElse(null);
			this.pmtFrqcy = ofNullable(builder.getPmtFrqcy()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("nm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nm")
		public String getNm() {
			return nm;
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rate")
		public FloatingRateIdentification8Choice__1 getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("refPrd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("refPrd")
		public InterestRateContractTerm4__1 getRefPrd() {
			return refPrd;
		}
		
		@Override
		@RosettaAttribute("sprd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sprd")
		public SecuritiesTransactionPrice20Choice__1 getSprd() {
			return sprd;
		}
		
		@Override
		@RosettaAttribute("dayCnt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCnt")
		public InterestComputationMethodFormat7__1 getDayCnt() {
			return dayCnt;
		}
		
		@Override
		@RosettaAttribute("pmtFrqcy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtFrqcy")
		public InterestRateFrequency3Choice__1 getPmtFrqcy() {
			return pmtFrqcy;
		}
		
		@Override
		public FloatingRate13__1 build() {
			return this;
		}
		
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder toBuilder() {
			FloatingRate13__1.FloatingRate13__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRate13__1.FloatingRate13__1Builder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getNm()).ifPresent(builder::setNm);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getRefPrd()).ifPresent(builder::setRefPrd);
			ofNullable(getSprd()).ifPresent(builder::setSprd);
			ofNullable(getDayCnt()).ifPresent(builder::setDayCnt);
			ofNullable(getPmtFrqcy()).ifPresent(builder::setPmtFrqcy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRate13__1 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(nm, _that.getNm())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(refPrd, _that.getRefPrd())) return false;
			if (!Objects.equals(sprd, _that.getSprd())) return false;
			if (!Objects.equals(dayCnt, _that.getDayCnt())) return false;
			if (!Objects.equals(pmtFrqcy, _that.getPmtFrqcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (nm != null ? nm.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (refPrd != null ? refPrd.hashCode() : 0);
			_result = 31 * _result + (sprd != null ? sprd.hashCode() : 0);
			_result = 31 * _result + (dayCnt != null ? dayCnt.hashCode() : 0);
			_result = 31 * _result + (pmtFrqcy != null ? pmtFrqcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRate13__1 {" +
				"id=" + this.id + ", " +
				"nm=" + this.nm + ", " +
				"rate=" + this.rate + ", " +
				"refPrd=" + this.refPrd + ", " +
				"sprd=" + this.sprd + ", " +
				"dayCnt=" + this.dayCnt + ", " +
				"pmtFrqcy=" + this.pmtFrqcy +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRate13__1  ***********************/
	class FloatingRate13__1BuilderImpl implements FloatingRate13__1.FloatingRate13__1Builder {
	
		protected String id;
		protected String nm;
		protected FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder rate;
		protected InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder refPrd;
		protected SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder sprd;
		protected InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder dayCnt;
		protected InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder pmtFrqcy;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("nm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nm")
		public String getNm() {
			return nm;
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rate")
		public FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder getRate() {
			return rate;
		}
		
		@Override
		public FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder getOrCreateRate() {
			FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder result;
			if (rate!=null) {
				result = rate;
			}
			else {
				result = rate = FloatingRateIdentification8Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("refPrd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("refPrd")
		public InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder getRefPrd() {
			return refPrd;
		}
		
		@Override
		public InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder getOrCreateRefPrd() {
			InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder result;
			if (refPrd!=null) {
				result = refPrd;
			}
			else {
				result = refPrd = InterestRateContractTerm4__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sprd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sprd")
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getSprd() {
			return sprd;
		}
		
		@Override
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getOrCreateSprd() {
			SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder result;
			if (sprd!=null) {
				result = sprd;
			}
			else {
				result = sprd = SecuritiesTransactionPrice20Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCnt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCnt")
		public InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder getDayCnt() {
			return dayCnt;
		}
		
		@Override
		public InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder getOrCreateDayCnt() {
			InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder result;
			if (dayCnt!=null) {
				result = dayCnt;
			}
			else {
				result = dayCnt = InterestComputationMethodFormat7__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pmtFrqcy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtFrqcy")
		public InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder getPmtFrqcy() {
			return pmtFrqcy;
		}
		
		@Override
		public InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder getOrCreatePmtFrqcy() {
			InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder result;
			if (pmtFrqcy!=null) {
				result = pmtFrqcy;
			}
			else {
				result = pmtFrqcy = InterestRateFrequency3Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("nm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nm")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder setNm(String _nm) {
			this.nm = _nm == null ? null : _nm;
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rate")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder setRate(FloatingRateIdentification8Choice__1 _rate) {
			this.rate = _rate == null ? null : _rate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("refPrd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("refPrd")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder setRefPrd(InterestRateContractTerm4__1 _refPrd) {
			this.refPrd = _refPrd == null ? null : _refPrd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sprd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sprd")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder setSprd(SecuritiesTransactionPrice20Choice__1 _sprd) {
			this.sprd = _sprd == null ? null : _sprd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCnt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCnt")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder setDayCnt(InterestComputationMethodFormat7__1 _dayCnt) {
			this.dayCnt = _dayCnt == null ? null : _dayCnt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pmtFrqcy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pmtFrqcy")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder setPmtFrqcy(InterestRateFrequency3Choice__1 _pmtFrqcy) {
			this.pmtFrqcy = _pmtFrqcy == null ? null : _pmtFrqcy.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRate13__1 build() {
			return new FloatingRate13__1.FloatingRate13__1Impl(this);
		}
		
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder prune() {
			if (rate!=null && !rate.prune().hasData()) rate = null;
			if (refPrd!=null && !refPrd.prune().hasData()) refPrd = null;
			if (sprd!=null && !sprd.prune().hasData()) sprd = null;
			if (dayCnt!=null && !dayCnt.prune().hasData()) dayCnt = null;
			if (pmtFrqcy!=null && !pmtFrqcy.prune().hasData()) pmtFrqcy = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getNm()!=null) return true;
			if (getRate()!=null && getRate().hasData()) return true;
			if (getRefPrd()!=null && getRefPrd().hasData()) return true;
			if (getSprd()!=null && getSprd().hasData()) return true;
			if (getDayCnt()!=null && getDayCnt().hasData()) return true;
			if (getPmtFrqcy()!=null && getPmtFrqcy().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRate13__1.FloatingRate13__1Builder o = (FloatingRate13__1.FloatingRate13__1Builder) other;
			
			merger.mergeRosetta(getRate(), o.getRate(), this::setRate);
			merger.mergeRosetta(getRefPrd(), o.getRefPrd(), this::setRefPrd);
			merger.mergeRosetta(getSprd(), o.getSprd(), this::setSprd);
			merger.mergeRosetta(getDayCnt(), o.getDayCnt(), this::setDayCnt);
			merger.mergeRosetta(getPmtFrqcy(), o.getPmtFrqcy(), this::setPmtFrqcy);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getNm(), o.getNm(), this::setNm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRate13__1 _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(nm, _that.getNm())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(refPrd, _that.getRefPrd())) return false;
			if (!Objects.equals(sprd, _that.getSprd())) return false;
			if (!Objects.equals(dayCnt, _that.getDayCnt())) return false;
			if (!Objects.equals(pmtFrqcy, _that.getPmtFrqcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (nm != null ? nm.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (refPrd != null ? refPrd.hashCode() : 0);
			_result = 31 * _result + (sprd != null ? sprd.hashCode() : 0);
			_result = 31 * _result + (dayCnt != null ? dayCnt.hashCode() : 0);
			_result = 31 * _result + (pmtFrqcy != null ? pmtFrqcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRate13__1Builder {" +
				"id=" + this.id + ", " +
				"nm=" + this.nm + ", " +
				"rate=" + this.rate + ", " +
				"refPrd=" + this.refPrd + ", " +
				"sprd=" + this.sprd + ", " +
				"dayCnt=" + this.dayCnt + ", " +
				"pmtFrqcy=" + this.pmtFrqcy +
			'}';
		}
	}
}
