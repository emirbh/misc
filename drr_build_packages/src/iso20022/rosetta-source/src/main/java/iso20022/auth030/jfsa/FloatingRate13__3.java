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
import iso20022.auth030.jfsa.meta.FloatingRate13__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRate13__3", builder=FloatingRate13__3.FloatingRate13__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FloatingRate13__3", model="iso20022", builder=FloatingRate13__3.FloatingRate13__3BuilderImpl.class, version="${project.version}")
public interface FloatingRate13__3 extends RosettaModelObject {

	FloatingRate13__3Meta metaData = new FloatingRate13__3Meta();

	/*********************** Getter Methods  ***********************/
	String getNm();
	FloatingRateIdentification8Choice__1 getRate();
	InterestRateContractTerm4__1 getRefPrd();
	SecuritiesTransactionPrice20Choice__1 getSprd();
	InterestComputationMethodFormat7__1 getDayCnt();
	InterestRateFrequency3Choice__2 getPmtFrqcy();
	InterestRateFrequency3Choice__2 getRstFrqcy();

	/*********************** Build Methods  ***********************/
	FloatingRate13__3 build();
	
	FloatingRate13__3.FloatingRate13__3Builder toBuilder();
	
	static FloatingRate13__3.FloatingRate13__3Builder builder() {
		return new FloatingRate13__3.FloatingRate13__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRate13__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRate13__3> getType() {
		return FloatingRate13__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nm"), String.class, getNm(), this);
		processRosetta(path.newSubPath("rate"), processor, FloatingRateIdentification8Choice__1.class, getRate());
		processRosetta(path.newSubPath("refPrd"), processor, InterestRateContractTerm4__1.class, getRefPrd());
		processRosetta(path.newSubPath("sprd"), processor, SecuritiesTransactionPrice20Choice__1.class, getSprd());
		processRosetta(path.newSubPath("dayCnt"), processor, InterestComputationMethodFormat7__1.class, getDayCnt());
		processRosetta(path.newSubPath("pmtFrqcy"), processor, InterestRateFrequency3Choice__2.class, getPmtFrqcy());
		processRosetta(path.newSubPath("rstFrqcy"), processor, InterestRateFrequency3Choice__2.class, getRstFrqcy());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRate13__3Builder extends FloatingRate13__3, RosettaModelObjectBuilder {
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
		InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder getOrCreatePmtFrqcy();
		@Override
		InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder getPmtFrqcy();
		InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder getOrCreateRstFrqcy();
		@Override
		InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder getRstFrqcy();
		FloatingRate13__3.FloatingRate13__3Builder setNm(String nm);
		FloatingRate13__3.FloatingRate13__3Builder setRate(FloatingRateIdentification8Choice__1 rate);
		FloatingRate13__3.FloatingRate13__3Builder setRefPrd(InterestRateContractTerm4__1 refPrd);
		FloatingRate13__3.FloatingRate13__3Builder setSprd(SecuritiesTransactionPrice20Choice__1 sprd);
		FloatingRate13__3.FloatingRate13__3Builder setDayCnt(InterestComputationMethodFormat7__1 dayCnt);
		FloatingRate13__3.FloatingRate13__3Builder setPmtFrqcy(InterestRateFrequency3Choice__2 pmtFrqcy);
		FloatingRate13__3.FloatingRate13__3Builder setRstFrqcy(InterestRateFrequency3Choice__2 rstFrqcy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("nm"), String.class, getNm(), this);
			processRosetta(path.newSubPath("rate"), processor, FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder.class, getRate());
			processRosetta(path.newSubPath("refPrd"), processor, InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder.class, getRefPrd());
			processRosetta(path.newSubPath("sprd"), processor, SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder.class, getSprd());
			processRosetta(path.newSubPath("dayCnt"), processor, InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder.class, getDayCnt());
			processRosetta(path.newSubPath("pmtFrqcy"), processor, InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder.class, getPmtFrqcy());
			processRosetta(path.newSubPath("rstFrqcy"), processor, InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder.class, getRstFrqcy());
		}
		

		FloatingRate13__3.FloatingRate13__3Builder prune();
	}

	/*********************** Immutable Implementation of FloatingRate13__3  ***********************/
	class FloatingRate13__3Impl implements FloatingRate13__3 {
		private final String nm;
		private final FloatingRateIdentification8Choice__1 rate;
		private final InterestRateContractTerm4__1 refPrd;
		private final SecuritiesTransactionPrice20Choice__1 sprd;
		private final InterestComputationMethodFormat7__1 dayCnt;
		private final InterestRateFrequency3Choice__2 pmtFrqcy;
		private final InterestRateFrequency3Choice__2 rstFrqcy;
		
		protected FloatingRate13__3Impl(FloatingRate13__3.FloatingRate13__3Builder builder) {
			this.nm = builder.getNm();
			this.rate = ofNullable(builder.getRate()).map(f->f.build()).orElse(null);
			this.refPrd = ofNullable(builder.getRefPrd()).map(f->f.build()).orElse(null);
			this.sprd = ofNullable(builder.getSprd()).map(f->f.build()).orElse(null);
			this.dayCnt = ofNullable(builder.getDayCnt()).map(f->f.build()).orElse(null);
			this.pmtFrqcy = ofNullable(builder.getPmtFrqcy()).map(f->f.build()).orElse(null);
			this.rstFrqcy = ofNullable(builder.getRstFrqcy()).map(f->f.build()).orElse(null);
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
		public InterestRateFrequency3Choice__2 getPmtFrqcy() {
			return pmtFrqcy;
		}
		
		@Override
		@RosettaAttribute("rstFrqcy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rstFrqcy")
		public InterestRateFrequency3Choice__2 getRstFrqcy() {
			return rstFrqcy;
		}
		
		@Override
		public FloatingRate13__3 build() {
			return this;
		}
		
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder toBuilder() {
			FloatingRate13__3.FloatingRate13__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRate13__3.FloatingRate13__3Builder builder) {
			ofNullable(getNm()).ifPresent(builder::setNm);
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getRefPrd()).ifPresent(builder::setRefPrd);
			ofNullable(getSprd()).ifPresent(builder::setSprd);
			ofNullable(getDayCnt()).ifPresent(builder::setDayCnt);
			ofNullable(getPmtFrqcy()).ifPresent(builder::setPmtFrqcy);
			ofNullable(getRstFrqcy()).ifPresent(builder::setRstFrqcy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRate13__3 _that = getType().cast(o);
		
			if (!Objects.equals(nm, _that.getNm())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(refPrd, _that.getRefPrd())) return false;
			if (!Objects.equals(sprd, _that.getSprd())) return false;
			if (!Objects.equals(dayCnt, _that.getDayCnt())) return false;
			if (!Objects.equals(pmtFrqcy, _that.getPmtFrqcy())) return false;
			if (!Objects.equals(rstFrqcy, _that.getRstFrqcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nm != null ? nm.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (refPrd != null ? refPrd.hashCode() : 0);
			_result = 31 * _result + (sprd != null ? sprd.hashCode() : 0);
			_result = 31 * _result + (dayCnt != null ? dayCnt.hashCode() : 0);
			_result = 31 * _result + (pmtFrqcy != null ? pmtFrqcy.hashCode() : 0);
			_result = 31 * _result + (rstFrqcy != null ? rstFrqcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRate13__3 {" +
				"nm=" + this.nm + ", " +
				"rate=" + this.rate + ", " +
				"refPrd=" + this.refPrd + ", " +
				"sprd=" + this.sprd + ", " +
				"dayCnt=" + this.dayCnt + ", " +
				"pmtFrqcy=" + this.pmtFrqcy + ", " +
				"rstFrqcy=" + this.rstFrqcy +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRate13__3  ***********************/
	class FloatingRate13__3BuilderImpl implements FloatingRate13__3.FloatingRate13__3Builder {
	
		protected String nm;
		protected FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder rate;
		protected InterestRateContractTerm4__1.InterestRateContractTerm4__1Builder refPrd;
		protected SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder sprd;
		protected InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder dayCnt;
		protected InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder pmtFrqcy;
		protected InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder rstFrqcy;
		
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
		public InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder getPmtFrqcy() {
			return pmtFrqcy;
		}
		
		@Override
		public InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder getOrCreatePmtFrqcy() {
			InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder result;
			if (pmtFrqcy!=null) {
				result = pmtFrqcy;
			}
			else {
				result = pmtFrqcy = InterestRateFrequency3Choice__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rstFrqcy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rstFrqcy")
		public InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder getRstFrqcy() {
			return rstFrqcy;
		}
		
		@Override
		public InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder getOrCreateRstFrqcy() {
			InterestRateFrequency3Choice__2.InterestRateFrequency3Choice__2Builder result;
			if (rstFrqcy!=null) {
				result = rstFrqcy;
			}
			else {
				result = rstFrqcy = InterestRateFrequency3Choice__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("nm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nm")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder setNm(String _nm) {
			this.nm = _nm == null ? null : _nm;
			return this;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rate")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder setRate(FloatingRateIdentification8Choice__1 _rate) {
			this.rate = _rate == null ? null : _rate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("refPrd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("refPrd")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder setRefPrd(InterestRateContractTerm4__1 _refPrd) {
			this.refPrd = _refPrd == null ? null : _refPrd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sprd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sprd")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder setSprd(SecuritiesTransactionPrice20Choice__1 _sprd) {
			this.sprd = _sprd == null ? null : _sprd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCnt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCnt")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder setDayCnt(InterestComputationMethodFormat7__1 _dayCnt) {
			this.dayCnt = _dayCnt == null ? null : _dayCnt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pmtFrqcy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pmtFrqcy")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder setPmtFrqcy(InterestRateFrequency3Choice__2 _pmtFrqcy) {
			this.pmtFrqcy = _pmtFrqcy == null ? null : _pmtFrqcy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rstFrqcy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rstFrqcy")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder setRstFrqcy(InterestRateFrequency3Choice__2 _rstFrqcy) {
			this.rstFrqcy = _rstFrqcy == null ? null : _rstFrqcy.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRate13__3 build() {
			return new FloatingRate13__3.FloatingRate13__3Impl(this);
		}
		
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder prune() {
			if (rate!=null && !rate.prune().hasData()) rate = null;
			if (refPrd!=null && !refPrd.prune().hasData()) refPrd = null;
			if (sprd!=null && !sprd.prune().hasData()) sprd = null;
			if (dayCnt!=null && !dayCnt.prune().hasData()) dayCnt = null;
			if (pmtFrqcy!=null && !pmtFrqcy.prune().hasData()) pmtFrqcy = null;
			if (rstFrqcy!=null && !rstFrqcy.prune().hasData()) rstFrqcy = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNm()!=null) return true;
			if (getRate()!=null && getRate().hasData()) return true;
			if (getRefPrd()!=null && getRefPrd().hasData()) return true;
			if (getSprd()!=null && getSprd().hasData()) return true;
			if (getDayCnt()!=null && getDayCnt().hasData()) return true;
			if (getPmtFrqcy()!=null && getPmtFrqcy().hasData()) return true;
			if (getRstFrqcy()!=null && getRstFrqcy().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate13__3.FloatingRate13__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRate13__3.FloatingRate13__3Builder o = (FloatingRate13__3.FloatingRate13__3Builder) other;
			
			merger.mergeRosetta(getRate(), o.getRate(), this::setRate);
			merger.mergeRosetta(getRefPrd(), o.getRefPrd(), this::setRefPrd);
			merger.mergeRosetta(getSprd(), o.getSprd(), this::setSprd);
			merger.mergeRosetta(getDayCnt(), o.getDayCnt(), this::setDayCnt);
			merger.mergeRosetta(getPmtFrqcy(), o.getPmtFrqcy(), this::setPmtFrqcy);
			merger.mergeRosetta(getRstFrqcy(), o.getRstFrqcy(), this::setRstFrqcy);
			
			merger.mergeBasic(getNm(), o.getNm(), this::setNm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRate13__3 _that = getType().cast(o);
		
			if (!Objects.equals(nm, _that.getNm())) return false;
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(refPrd, _that.getRefPrd())) return false;
			if (!Objects.equals(sprd, _that.getSprd())) return false;
			if (!Objects.equals(dayCnt, _that.getDayCnt())) return false;
			if (!Objects.equals(pmtFrqcy, _that.getPmtFrqcy())) return false;
			if (!Objects.equals(rstFrqcy, _that.getRstFrqcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nm != null ? nm.hashCode() : 0);
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (refPrd != null ? refPrd.hashCode() : 0);
			_result = 31 * _result + (sprd != null ? sprd.hashCode() : 0);
			_result = 31 * _result + (dayCnt != null ? dayCnt.hashCode() : 0);
			_result = 31 * _result + (pmtFrqcy != null ? pmtFrqcy.hashCode() : 0);
			_result = 31 * _result + (rstFrqcy != null ? rstFrqcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRate13__3Builder {" +
				"nm=" + this.nm + ", " +
				"rate=" + this.rate + ", " +
				"refPrd=" + this.refPrd + ", " +
				"sprd=" + this.sprd + ", " +
				"dayCnt=" + this.dayCnt + ", " +
				"pmtFrqcy=" + this.pmtFrqcy + ", " +
				"rstFrqcy=" + this.rstFrqcy +
			'}';
		}
	}
}
