package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.CreditDefaultSwapChoiceMeta;
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
@RosettaDataType(value="CreditDefaultSwapChoice", builder=CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CreditDefaultSwapChoice", model="fpml", builder=CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilderImpl.class, version="2.1.1")
public interface CreditDefaultSwapChoice extends RosettaModelObject {

	CreditDefaultSwapChoiceMeta metaData = new CreditDefaultSwapChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the ISDA terms relevant to cash settlement for when cash settlement is applicable. ISDA 2003 Term: Cash Settlement
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the ISDA terms relevant to cash settlement for when cash settlement is applicable. ISDA 2003 Term: Cash Settlement
	 *
	 */
	CashSettlementTerms getCashSettlementTerms();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the ISDA terms relevant to physical settlement for when physical settlement is applicable. ISDA 2003 Term: Physical Settlement
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the ISDA terms relevant to physical settlement for when physical settlement is applicable. ISDA 2003 Term: Physical Settlement
	 *
	 */
	PhysicalSettlementTerms getPhysicalSettlementTerms();

	/*********************** Build Methods  ***********************/
	CreditDefaultSwapChoice build();
	
	CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder toBuilder();
	
	static CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder builder() {
		return new CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditDefaultSwapChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditDefaultSwapChoice> getType() {
		return CreditDefaultSwapChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashSettlementTerms"), processor, CashSettlementTerms.class, getCashSettlementTerms());
		processRosetta(path.newSubPath("physicalSettlementTerms"), processor, PhysicalSettlementTerms.class, getPhysicalSettlementTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditDefaultSwapChoiceBuilder extends CreditDefaultSwapChoice, RosettaModelObjectBuilder {
		CashSettlementTerms.CashSettlementTermsBuilder getOrCreateCashSettlementTerms();
		@Override
		CashSettlementTerms.CashSettlementTermsBuilder getCashSettlementTerms();
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTerms();
		@Override
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getPhysicalSettlementTerms();
		CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder setCashSettlementTerms(CashSettlementTerms cashSettlementTerms);
		CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder setPhysicalSettlementTerms(PhysicalSettlementTerms physicalSettlementTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashSettlementTerms"), processor, CashSettlementTerms.CashSettlementTermsBuilder.class, getCashSettlementTerms());
			processRosetta(path.newSubPath("physicalSettlementTerms"), processor, PhysicalSettlementTerms.PhysicalSettlementTermsBuilder.class, getPhysicalSettlementTerms());
		}
		

		CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of CreditDefaultSwapChoice  ***********************/
	class CreditDefaultSwapChoiceImpl implements CreditDefaultSwapChoice {
		private final CashSettlementTerms cashSettlementTerms;
		private final PhysicalSettlementTerms physicalSettlementTerms;
		
		protected CreditDefaultSwapChoiceImpl(CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder builder) {
			this.cashSettlementTerms = ofNullable(builder.getCashSettlementTerms()).map(f->f.build()).orElse(null);
			this.physicalSettlementTerms = ofNullable(builder.getPhysicalSettlementTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashSettlementTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementTerms")
		public CashSettlementTerms getCashSettlementTerms() {
			return cashSettlementTerms;
		}
		
		@Override
		@RosettaAttribute("physicalSettlementTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlementTerms")
		public PhysicalSettlementTerms getPhysicalSettlementTerms() {
			return physicalSettlementTerms;
		}
		
		@Override
		public CreditDefaultSwapChoice build() {
			return this;
		}
		
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder toBuilder() {
			CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder builder) {
			ofNullable(getCashSettlementTerms()).ifPresent(builder::setCashSettlementTerms);
			ofNullable(getPhysicalSettlementTerms()).ifPresent(builder::setPhysicalSettlementTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditDefaultSwapChoice _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementTerms, _that.getCashSettlementTerms())) return false;
			if (!Objects.equals(physicalSettlementTerms, _that.getPhysicalSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementTerms != null ? cashSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTerms != null ? physicalSettlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwapChoice {" +
				"cashSettlementTerms=" + this.cashSettlementTerms + ", " +
				"physicalSettlementTerms=" + this.physicalSettlementTerms +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditDefaultSwapChoice  ***********************/
	class CreditDefaultSwapChoiceBuilderImpl implements CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder {
	
		protected CashSettlementTerms.CashSettlementTermsBuilder cashSettlementTerms;
		protected PhysicalSettlementTerms.PhysicalSettlementTermsBuilder physicalSettlementTerms;
		
		@Override
		@RosettaAttribute("cashSettlementTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlementTerms")
		public CashSettlementTerms.CashSettlementTermsBuilder getCashSettlementTerms() {
			return cashSettlementTerms;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder getOrCreateCashSettlementTerms() {
			CashSettlementTerms.CashSettlementTermsBuilder result;
			if (cashSettlementTerms!=null) {
				result = cashSettlementTerms;
			}
			else {
				result = cashSettlementTerms = CashSettlementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalSettlementTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalSettlementTerms")
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getPhysicalSettlementTerms() {
			return physicalSettlementTerms;
		}
		
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTerms() {
			PhysicalSettlementTerms.PhysicalSettlementTermsBuilder result;
			if (physicalSettlementTerms!=null) {
				result = physicalSettlementTerms;
			}
			else {
				result = physicalSettlementTerms = PhysicalSettlementTerms.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cashSettlementTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlementTerms")
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder setCashSettlementTerms(CashSettlementTerms _cashSettlementTerms) {
			this.cashSettlementTerms = _cashSettlementTerms == null ? null : _cashSettlementTerms.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalSettlementTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalSettlementTerms")
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder setPhysicalSettlementTerms(PhysicalSettlementTerms _physicalSettlementTerms) {
			this.physicalSettlementTerms = _physicalSettlementTerms == null ? null : _physicalSettlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public CreditDefaultSwapChoice build() {
			return new CreditDefaultSwapChoice.CreditDefaultSwapChoiceImpl(this);
		}
		
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder prune() {
			if (cashSettlementTerms!=null && !cashSettlementTerms.prune().hasData()) cashSettlementTerms = null;
			if (physicalSettlementTerms!=null && !physicalSettlementTerms.prune().hasData()) physicalSettlementTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashSettlementTerms()!=null && getCashSettlementTerms().hasData()) return true;
			if (getPhysicalSettlementTerms()!=null && getPhysicalSettlementTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder o = (CreditDefaultSwapChoice.CreditDefaultSwapChoiceBuilder) other;
			
			merger.mergeRosetta(getCashSettlementTerms(), o.getCashSettlementTerms(), this::setCashSettlementTerms);
			merger.mergeRosetta(getPhysicalSettlementTerms(), o.getPhysicalSettlementTerms(), this::setPhysicalSettlementTerms);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditDefaultSwapChoice _that = getType().cast(o);
		
			if (!Objects.equals(cashSettlementTerms, _that.getCashSettlementTerms())) return false;
			if (!Objects.equals(physicalSettlementTerms, _that.getPhysicalSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashSettlementTerms != null ? cashSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTerms != null ? physicalSettlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultSwapChoiceBuilder {" +
				"cashSettlementTerms=" + this.cashSettlementTerms + ", " +
				"physicalSettlementTerms=" + this.physicalSettlementTerms +
			'}';
		}
	}
}
