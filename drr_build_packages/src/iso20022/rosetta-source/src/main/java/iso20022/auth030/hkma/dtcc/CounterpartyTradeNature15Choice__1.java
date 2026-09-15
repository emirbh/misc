package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.CounterpartyTradeNature15Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Nature of the counterparty&#39;s company activities.
 * @version ${project.version}
 */
@RosettaDataType(value="CounterpartyTradeNature15Choice__1", builder=CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CounterpartyTradeNature15Choice__1", model="iso20022", builder=CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1BuilderImpl.class, version="${project.version}")
public interface CounterpartyTradeNature15Choice__1 extends RosettaModelObject {

	CounterpartyTradeNature15Choice__1Meta metaData = new CounterpartyTradeNature15Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates that counterparty is a financial institution.
	 */
	FinancialInstitutionSector1__1 getFi();
	/**
	 * Indicates that counterparty is a non financial institution.
	 */
	NonFinancialInstitutionSector10__1 getNfi();
	/**
	 * Indicates that reporting party is a central counterparty.
	 */
	NoReasonCode getCntrlCntrPty();
	/**
	 * Indicates that reporting party is other type of counterparty.
	 */
	NoReasonCode getOthr();

	/*********************** Build Methods  ***********************/
	CounterpartyTradeNature15Choice__1 build();
	
	CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder toBuilder();
	
	static CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder builder() {
		return new CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CounterpartyTradeNature15Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CounterpartyTradeNature15Choice__1> getType() {
		return CounterpartyTradeNature15Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fi"), processor, FinancialInstitutionSector1__1.class, getFi());
		processRosetta(path.newSubPath("nfi"), processor, NonFinancialInstitutionSector10__1.class, getNfi());
		processor.processBasic(path.newSubPath("cntrlCntrPty"), NoReasonCode.class, getCntrlCntrPty(), this);
		processor.processBasic(path.newSubPath("othr"), NoReasonCode.class, getOthr(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CounterpartyTradeNature15Choice__1Builder extends CounterpartyTradeNature15Choice__1, RosettaModelObjectBuilder {
		FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder getOrCreateFi();
		@Override
		FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder getFi();
		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder getOrCreateNfi();
		@Override
		NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder getNfi();
		CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder setFi(FinancialInstitutionSector1__1 fi);
		CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder setNfi(NonFinancialInstitutionSector10__1 nfi);
		CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder setCntrlCntrPty(NoReasonCode cntrlCntrPty);
		CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder setOthr(NoReasonCode othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fi"), processor, FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder.class, getFi());
			processRosetta(path.newSubPath("nfi"), processor, NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder.class, getNfi());
			processor.processBasic(path.newSubPath("cntrlCntrPty"), NoReasonCode.class, getCntrlCntrPty(), this);
			processor.processBasic(path.newSubPath("othr"), NoReasonCode.class, getOthr(), this);
		}
		

		CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of CounterpartyTradeNature15Choice__1  ***********************/
	class CounterpartyTradeNature15Choice__1Impl implements CounterpartyTradeNature15Choice__1 {
		private final FinancialInstitutionSector1__1 fi;
		private final NonFinancialInstitutionSector10__1 nfi;
		private final NoReasonCode cntrlCntrPty;
		private final NoReasonCode othr;
		
		protected CounterpartyTradeNature15Choice__1Impl(CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder builder) {
			this.fi = ofNullable(builder.getFi()).map(f->f.build()).orElse(null);
			this.nfi = ofNullable(builder.getNfi()).map(f->f.build()).orElse(null);
			this.cntrlCntrPty = builder.getCntrlCntrPty();
			this.othr = builder.getOthr();
		}
		
		@Override
		@RosettaAttribute("fi")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fi")
		public FinancialInstitutionSector1__1 getFi() {
			return fi;
		}
		
		@Override
		@RosettaAttribute("nfi")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nfi")
		public NonFinancialInstitutionSector10__1 getNfi() {
			return nfi;
		}
		
		@Override
		@RosettaAttribute("cntrlCntrPty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cntrlCntrPty")
		public NoReasonCode getCntrlCntrPty() {
			return cntrlCntrPty;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public NoReasonCode getOthr() {
			return othr;
		}
		
		@Override
		public CounterpartyTradeNature15Choice__1 build() {
			return this;
		}
		
		@Override
		public CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder toBuilder() {
			CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder builder) {
			ofNullable(getFi()).ifPresent(builder::setFi);
			ofNullable(getNfi()).ifPresent(builder::setNfi);
			ofNullable(getCntrlCntrPty()).ifPresent(builder::setCntrlCntrPty);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartyTradeNature15Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(fi, _that.getFi())) return false;
			if (!Objects.equals(nfi, _that.getNfi())) return false;
			if (!Objects.equals(cntrlCntrPty, _that.getCntrlCntrPty())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fi != null ? fi.hashCode() : 0);
			_result = 31 * _result + (nfi != null ? nfi.hashCode() : 0);
			_result = 31 * _result + (cntrlCntrPty != null ? cntrlCntrPty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CounterpartyTradeNature15Choice__1 {" +
				"fi=" + this.fi + ", " +
				"nfi=" + this.nfi + ", " +
				"cntrlCntrPty=" + this.cntrlCntrPty + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of CounterpartyTradeNature15Choice__1  ***********************/
	class CounterpartyTradeNature15Choice__1BuilderImpl implements CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder {
	
		protected FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder fi;
		protected NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder nfi;
		protected NoReasonCode cntrlCntrPty;
		protected NoReasonCode othr;
		
		@Override
		@RosettaAttribute("fi")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fi")
		public FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder getFi() {
			return fi;
		}
		
		@Override
		public FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder getOrCreateFi() {
			FinancialInstitutionSector1__1.FinancialInstitutionSector1__1Builder result;
			if (fi!=null) {
				result = fi;
			}
			else {
				result = fi = FinancialInstitutionSector1__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nfi")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nfi")
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder getNfi() {
			return nfi;
		}
		
		@Override
		public NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder getOrCreateNfi() {
			NonFinancialInstitutionSector10__1.NonFinancialInstitutionSector10__1Builder result;
			if (nfi!=null) {
				result = nfi;
			}
			else {
				result = nfi = NonFinancialInstitutionSector10__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cntrlCntrPty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cntrlCntrPty")
		public NoReasonCode getCntrlCntrPty() {
			return cntrlCntrPty;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public NoReasonCode getOthr() {
			return othr;
		}
		
		@RosettaAttribute("fi")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fi")
		@Override
		public CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder setFi(FinancialInstitutionSector1__1 _fi) {
			this.fi = _fi == null ? null : _fi.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nfi")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nfi")
		@Override
		public CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder setNfi(NonFinancialInstitutionSector10__1 _nfi) {
			this.nfi = _nfi == null ? null : _nfi.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cntrlCntrPty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cntrlCntrPty")
		@Override
		public CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder setCntrlCntrPty(NoReasonCode _cntrlCntrPty) {
			this.cntrlCntrPty = _cntrlCntrPty == null ? null : _cntrlCntrPty;
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder setOthr(NoReasonCode _othr) {
			this.othr = _othr == null ? null : _othr;
			return this;
		}
		
		@Override
		public CounterpartyTradeNature15Choice__1 build() {
			return new CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Impl(this);
		}
		
		@Override
		public CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder prune() {
			if (fi!=null && !fi.prune().hasData()) fi = null;
			if (nfi!=null && !nfi.prune().hasData()) nfi = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFi()!=null && getFi().hasData()) return true;
			if (getNfi()!=null && getNfi().hasData()) return true;
			if (getCntrlCntrPty()!=null) return true;
			if (getOthr()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder o = (CounterpartyTradeNature15Choice__1.CounterpartyTradeNature15Choice__1Builder) other;
			
			merger.mergeRosetta(getFi(), o.getFi(), this::setFi);
			merger.mergeRosetta(getNfi(), o.getNfi(), this::setNfi);
			
			merger.mergeBasic(getCntrlCntrPty(), o.getCntrlCntrPty(), this::setCntrlCntrPty);
			merger.mergeBasic(getOthr(), o.getOthr(), this::setOthr);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartyTradeNature15Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(fi, _that.getFi())) return false;
			if (!Objects.equals(nfi, _that.getNfi())) return false;
			if (!Objects.equals(cntrlCntrPty, _that.getCntrlCntrPty())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fi != null ? fi.hashCode() : 0);
			_result = 31 * _result + (nfi != null ? nfi.hashCode() : 0);
			_result = 31 * _result + (cntrlCntrPty != null ? cntrlCntrPty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CounterpartyTradeNature15Choice__1Builder {" +
				"fi=" + this.fi + ", " +
				"nfi=" + this.nfi + ", " +
				"cntrlCntrPty=" + this.cntrlCntrPty + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
