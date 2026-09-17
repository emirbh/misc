package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.MandatoryEarlyTerminationMeta;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.CalculationAgent;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type to define an early termination provision for which exercise is mandatory.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to define an early termination provision for which exercise is mandatory.
 *
 */
@RosettaDataType(value="MandatoryEarlyTermination", builder=MandatoryEarlyTermination.MandatoryEarlyTerminationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MandatoryEarlyTermination", model="fpml", builder=MandatoryEarlyTermination.MandatoryEarlyTerminationBuilderImpl.class, version="2.1.1")
public interface MandatoryEarlyTermination extends RosettaModelObject {

	MandatoryEarlyTerminationMeta metaData = new MandatoryEarlyTerminationMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The early termination date associated with a mandatory early termination of a swap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The early termination date associated with a mandatory early termination of a swap.
	 *
	 */
	AdjustableDate getMandatoryEarlyTerminationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
	 *
	 */
	CalculationAgent getCalculationAgent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement prodcedure. If not specified, then physical settlement is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement prodcedure. If not specified, then physical settlement is applicable.
	 *
	 */
	CashSettlement getCashSettlement();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The adjusted dates associated with a mandatory early termination provision. These dates have been adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The adjusted dates associated with a mandatory early termination provision. These dates have been adjusted for any applicable business day convention.
	 *
	 */
	MandatoryEarlyTerminationAdjustedDates getMandatoryEarlyTerminationAdjustedDates();

	/*********************** Build Methods  ***********************/
	MandatoryEarlyTermination build();
	
	MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder toBuilder();
	
	static MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder builder() {
		return new MandatoryEarlyTermination.MandatoryEarlyTerminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MandatoryEarlyTermination> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MandatoryEarlyTermination> getType() {
		return MandatoryEarlyTermination.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("mandatoryEarlyTerminationDate"), processor, AdjustableDate.class, getMandatoryEarlyTerminationDate());
		processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.class, getCalculationAgent());
		processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlement.class, getCashSettlement());
		processRosetta(path.newSubPath("mandatoryEarlyTerminationAdjustedDates"), processor, MandatoryEarlyTerminationAdjustedDates.class, getMandatoryEarlyTerminationAdjustedDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MandatoryEarlyTerminationBuilder extends MandatoryEarlyTermination, RosettaModelObjectBuilder {
		AdjustableDate.AdjustableDateBuilder getOrCreateMandatoryEarlyTerminationDate();
		@Override
		AdjustableDate.AdjustableDateBuilder getMandatoryEarlyTerminationDate();
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent();
		@Override
		CalculationAgent.CalculationAgentBuilder getCalculationAgent();
		CashSettlement.CashSettlementBuilder getOrCreateCashSettlement();
		@Override
		CashSettlement.CashSettlementBuilder getCashSettlement();
		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder getOrCreateMandatoryEarlyTerminationAdjustedDates();
		@Override
		MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder getMandatoryEarlyTerminationAdjustedDates();
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setId(String id);
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setMandatoryEarlyTerminationDate(AdjustableDate mandatoryEarlyTerminationDate);
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setCalculationAgent(CalculationAgent calculationAgent);
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setCashSettlement(CashSettlement cashSettlement);
		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setMandatoryEarlyTerminationAdjustedDates(MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("mandatoryEarlyTerminationDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getMandatoryEarlyTerminationDate());
			processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgent());
			processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlement.CashSettlementBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("mandatoryEarlyTerminationAdjustedDates"), processor, MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder.class, getMandatoryEarlyTerminationAdjustedDates());
		}
		

		MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder prune();
	}

	/*********************** Immutable Implementation of MandatoryEarlyTermination  ***********************/
	class MandatoryEarlyTerminationImpl implements MandatoryEarlyTermination {
		private final String id;
		private final AdjustableDate mandatoryEarlyTerminationDate;
		private final CalculationAgent calculationAgent;
		private final CashSettlement cashSettlement;
		private final MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates;
		
		protected MandatoryEarlyTerminationImpl(MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder builder) {
			this.id = builder.getId();
			this.mandatoryEarlyTerminationDate = ofNullable(builder.getMandatoryEarlyTerminationDate()).map(f->f.build()).orElse(null);
			this.calculationAgent = ofNullable(builder.getCalculationAgent()).map(f->f.build()).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.mandatoryEarlyTerminationAdjustedDates = ofNullable(builder.getMandatoryEarlyTerminationAdjustedDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryEarlyTerminationDate")
		public AdjustableDate getMandatoryEarlyTerminationDate() {
			return mandatoryEarlyTerminationDate;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgent")
		public CalculationAgent getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public CashSettlement getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationAdjustedDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryEarlyTerminationAdjustedDates")
		public MandatoryEarlyTerminationAdjustedDates getMandatoryEarlyTerminationAdjustedDates() {
			return mandatoryEarlyTerminationAdjustedDates;
		}
		
		@Override
		public MandatoryEarlyTermination build() {
			return this;
		}
		
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder toBuilder() {
			MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getMandatoryEarlyTerminationDate()).ifPresent(builder::setMandatoryEarlyTerminationDate);
			ofNullable(getCalculationAgent()).ifPresent(builder::setCalculationAgent);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getMandatoryEarlyTerminationAdjustedDates()).ifPresent(builder::setMandatoryEarlyTerminationAdjustedDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(mandatoryEarlyTerminationDate, _that.getMandatoryEarlyTerminationDate())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(mandatoryEarlyTerminationAdjustedDates, _that.getMandatoryEarlyTerminationAdjustedDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTerminationDate != null ? mandatoryEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTerminationAdjustedDates != null ? mandatoryEarlyTerminationAdjustedDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTermination {" +
				"id=" + this.id + ", " +
				"mandatoryEarlyTerminationDate=" + this.mandatoryEarlyTerminationDate + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"mandatoryEarlyTerminationAdjustedDates=" + this.mandatoryEarlyTerminationAdjustedDates +
			'}';
		}
	}

	/*********************** Builder Implementation of MandatoryEarlyTermination  ***********************/
	class MandatoryEarlyTerminationBuilderImpl implements MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder {
	
		protected String id;
		protected AdjustableDate.AdjustableDateBuilder mandatoryEarlyTerminationDate;
		protected CalculationAgent.CalculationAgentBuilder calculationAgent;
		protected CashSettlement.CashSettlementBuilder cashSettlement;
		protected MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder mandatoryEarlyTerminationAdjustedDates;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryEarlyTerminationDate")
		public AdjustableDate.AdjustableDateBuilder getMandatoryEarlyTerminationDate() {
			return mandatoryEarlyTerminationDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateMandatoryEarlyTerminationDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (mandatoryEarlyTerminationDate!=null) {
				result = mandatoryEarlyTerminationDate;
			}
			else {
				result = mandatoryEarlyTerminationDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationAgent")
		public CalculationAgent.CalculationAgentBuilder getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgent!=null) {
				result = calculationAgent;
			}
			else {
				result = calculationAgent = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashSettlement")
		public CashSettlement.CashSettlementBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public CashSettlement.CashSettlementBuilder getOrCreateCashSettlement() {
			CashSettlement.CashSettlementBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = CashSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatoryEarlyTerminationAdjustedDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatoryEarlyTerminationAdjustedDates")
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder getMandatoryEarlyTerminationAdjustedDates() {
			return mandatoryEarlyTerminationAdjustedDates;
		}
		
		@Override
		public MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder getOrCreateMandatoryEarlyTerminationAdjustedDates() {
			MandatoryEarlyTerminationAdjustedDates.MandatoryEarlyTerminationAdjustedDatesBuilder result;
			if (mandatoryEarlyTerminationAdjustedDates!=null) {
				result = mandatoryEarlyTerminationAdjustedDates;
			}
			else {
				result = mandatoryEarlyTerminationAdjustedDates = MandatoryEarlyTerminationAdjustedDates.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("mandatoryEarlyTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryEarlyTerminationDate")
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setMandatoryEarlyTerminationDate(AdjustableDate _mandatoryEarlyTerminationDate) {
			this.mandatoryEarlyTerminationDate = _mandatoryEarlyTerminationDate == null ? null : _mandatoryEarlyTerminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationAgent")
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setCalculationAgent(CalculationAgent _calculationAgent) {
			this.calculationAgent = _calculationAgent == null ? null : _calculationAgent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashSettlement")
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setCashSettlement(CashSettlement _cashSettlement) {
			this.cashSettlement = _cashSettlement == null ? null : _cashSettlement.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mandatoryEarlyTerminationAdjustedDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatoryEarlyTerminationAdjustedDates")
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder setMandatoryEarlyTerminationAdjustedDates(MandatoryEarlyTerminationAdjustedDates _mandatoryEarlyTerminationAdjustedDates) {
			this.mandatoryEarlyTerminationAdjustedDates = _mandatoryEarlyTerminationAdjustedDates == null ? null : _mandatoryEarlyTerminationAdjustedDates.toBuilder();
			return this;
		}
		
		@Override
		public MandatoryEarlyTermination build() {
			return new MandatoryEarlyTermination.MandatoryEarlyTerminationImpl(this);
		}
		
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder prune() {
			if (mandatoryEarlyTerminationDate!=null && !mandatoryEarlyTerminationDate.prune().hasData()) mandatoryEarlyTerminationDate = null;
			if (calculationAgent!=null && !calculationAgent.prune().hasData()) calculationAgent = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (mandatoryEarlyTerminationAdjustedDates!=null && !mandatoryEarlyTerminationAdjustedDates.prune().hasData()) mandatoryEarlyTerminationAdjustedDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getMandatoryEarlyTerminationDate()!=null && getMandatoryEarlyTerminationDate().hasData()) return true;
			if (getCalculationAgent()!=null && getCalculationAgent().hasData()) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getMandatoryEarlyTerminationAdjustedDates()!=null && getMandatoryEarlyTerminationAdjustedDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder o = (MandatoryEarlyTermination.MandatoryEarlyTerminationBuilder) other;
			
			merger.mergeRosetta(getMandatoryEarlyTerminationDate(), o.getMandatoryEarlyTerminationDate(), this::setMandatoryEarlyTerminationDate);
			merger.mergeRosetta(getCalculationAgent(), o.getCalculationAgent(), this::setCalculationAgent);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getMandatoryEarlyTerminationAdjustedDates(), o.getMandatoryEarlyTerminationAdjustedDates(), this::setMandatoryEarlyTerminationAdjustedDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MandatoryEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(mandatoryEarlyTerminationDate, _that.getMandatoryEarlyTerminationDate())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(mandatoryEarlyTerminationAdjustedDates, _that.getMandatoryEarlyTerminationAdjustedDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTerminationDate != null ? mandatoryEarlyTerminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (mandatoryEarlyTerminationAdjustedDates != null ? mandatoryEarlyTerminationAdjustedDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MandatoryEarlyTerminationBuilder {" +
				"id=" + this.id + ", " +
				"mandatoryEarlyTerminationDate=" + this.mandatoryEarlyTerminationDate + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"mandatoryEarlyTerminationAdjustedDates=" + this.mandatoryEarlyTerminationAdjustedDates +
			'}';
		}
	}
}
