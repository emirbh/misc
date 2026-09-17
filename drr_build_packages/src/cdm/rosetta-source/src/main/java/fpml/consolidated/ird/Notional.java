package fpml.consolidated.ird;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.ird.meta.NotionalMeta;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision An type defining the notional amount or notional amount schedule associated with a swap stream. The notional schedule will be captured explicitly, specifying the dates that the notional changes and the outstanding notional amount that applies from that date. A parametric representation of the rules defining the notional step schedule can optionally be included.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An type defining the notional amount or notional amount schedule associated with a swap stream. The notional schedule will be captured explicitly, specifying the dates that the notional changes and the outstanding notional amount that applies from that date. A parametric representation of the rules defining the notional step schedule can optionally be included.
 *
 */
@RosettaDataType(value="Notional", builder=Notional.NotionalBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Notional", model="fpml", builder=Notional.NotionalBuilderImpl.class, version="2.1.1")
public interface Notional extends RosettaModelObject {

	NotionalMeta metaData = new NotionalMeta();

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
	 * Provision The notional amount or notional amount schedule expressed as explicit outstanding notional amounts and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The notional amount or notional amount schedule expressed as explicit outstanding notional amounts and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments.
	 *
	 */
	NonNegativeAmountSchedule getNotionalStepSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A parametric representation of the notional step schedule, i.e. parameters used to generate the notional schedule.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A parametric representation of the notional step schedule, i.e. parameters used to generate the notional schedule.
	 *
	 */
	NotionalStepRule getNotionalStepParameters();

	/*********************** Build Methods  ***********************/
	Notional build();
	
	Notional.NotionalBuilder toBuilder();
	
	static Notional.NotionalBuilder builder() {
		return new Notional.NotionalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Notional> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Notional> getType() {
		return Notional.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("notionalStepSchedule"), processor, NonNegativeAmountSchedule.class, getNotionalStepSchedule());
		processRosetta(path.newSubPath("notionalStepParameters"), processor, NotionalStepRule.class, getNotionalStepParameters());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalBuilder extends Notional, RosettaModelObjectBuilder {
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalStepSchedule();
		@Override
		NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalStepSchedule();
		NotionalStepRule.NotionalStepRuleBuilder getOrCreateNotionalStepParameters();
		@Override
		NotionalStepRule.NotionalStepRuleBuilder getNotionalStepParameters();
		Notional.NotionalBuilder setId(String id);
		Notional.NotionalBuilder setNotionalStepSchedule(NonNegativeAmountSchedule notionalStepSchedule);
		Notional.NotionalBuilder setNotionalStepParameters(NotionalStepRule notionalStepParameters);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("notionalStepSchedule"), processor, NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder.class, getNotionalStepSchedule());
			processRosetta(path.newSubPath("notionalStepParameters"), processor, NotionalStepRule.NotionalStepRuleBuilder.class, getNotionalStepParameters());
		}
		

		Notional.NotionalBuilder prune();
	}

	/*********************** Immutable Implementation of Notional  ***********************/
	class NotionalImpl implements Notional {
		private final String id;
		private final NonNegativeAmountSchedule notionalStepSchedule;
		private final NotionalStepRule notionalStepParameters;
		
		protected NotionalImpl(Notional.NotionalBuilder builder) {
			this.id = builder.getId();
			this.notionalStepSchedule = ofNullable(builder.getNotionalStepSchedule()).map(f->f.build()).orElse(null);
			this.notionalStepParameters = ofNullable(builder.getNotionalStepParameters()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("notionalStepSchedule")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notionalStepSchedule")
		public NonNegativeAmountSchedule getNotionalStepSchedule() {
			return notionalStepSchedule;
		}
		
		@Override
		@RosettaAttribute("notionalStepParameters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalStepParameters")
		public NotionalStepRule getNotionalStepParameters() {
			return notionalStepParameters;
		}
		
		@Override
		public Notional build() {
			return this;
		}
		
		@Override
		public Notional.NotionalBuilder toBuilder() {
			Notional.NotionalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Notional.NotionalBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getNotionalStepSchedule()).ifPresent(builder::setNotionalStepSchedule);
			ofNullable(getNotionalStepParameters()).ifPresent(builder::setNotionalStepParameters);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Notional _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(notionalStepSchedule, _that.getNotionalStepSchedule())) return false;
			if (!Objects.equals(notionalStepParameters, _that.getNotionalStepParameters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (notionalStepSchedule != null ? notionalStepSchedule.hashCode() : 0);
			_result = 31 * _result + (notionalStepParameters != null ? notionalStepParameters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Notional {" +
				"id=" + this.id + ", " +
				"notionalStepSchedule=" + this.notionalStepSchedule + ", " +
				"notionalStepParameters=" + this.notionalStepParameters +
			'}';
		}
	}

	/*********************** Builder Implementation of Notional  ***********************/
	class NotionalBuilderImpl implements Notional.NotionalBuilder {
	
		protected String id;
		protected NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder notionalStepSchedule;
		protected NotionalStepRule.NotionalStepRuleBuilder notionalStepParameters;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("notionalStepSchedule")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("notionalStepSchedule")
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getNotionalStepSchedule() {
			return notionalStepSchedule;
		}
		
		@Override
		public NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder getOrCreateNotionalStepSchedule() {
			NonNegativeAmountSchedule.NonNegativeAmountScheduleBuilder result;
			if (notionalStepSchedule!=null) {
				result = notionalStepSchedule;
			}
			else {
				result = notionalStepSchedule = NonNegativeAmountSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalStepParameters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalStepParameters")
		public NotionalStepRule.NotionalStepRuleBuilder getNotionalStepParameters() {
			return notionalStepParameters;
		}
		
		@Override
		public NotionalStepRule.NotionalStepRuleBuilder getOrCreateNotionalStepParameters() {
			NotionalStepRule.NotionalStepRuleBuilder result;
			if (notionalStepParameters!=null) {
				result = notionalStepParameters;
			}
			else {
				result = notionalStepParameters = NotionalStepRule.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Notional.NotionalBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("notionalStepSchedule")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("notionalStepSchedule")
		@Override
		public Notional.NotionalBuilder setNotionalStepSchedule(NonNegativeAmountSchedule _notionalStepSchedule) {
			this.notionalStepSchedule = _notionalStepSchedule == null ? null : _notionalStepSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalStepParameters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalStepParameters")
		@Override
		public Notional.NotionalBuilder setNotionalStepParameters(NotionalStepRule _notionalStepParameters) {
			this.notionalStepParameters = _notionalStepParameters == null ? null : _notionalStepParameters.toBuilder();
			return this;
		}
		
		@Override
		public Notional build() {
			return new Notional.NotionalImpl(this);
		}
		
		@Override
		public Notional.NotionalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Notional.NotionalBuilder prune() {
			if (notionalStepSchedule!=null && !notionalStepSchedule.prune().hasData()) notionalStepSchedule = null;
			if (notionalStepParameters!=null && !notionalStepParameters.prune().hasData()) notionalStepParameters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getNotionalStepSchedule()!=null && getNotionalStepSchedule().hasData()) return true;
			if (getNotionalStepParameters()!=null && getNotionalStepParameters().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Notional.NotionalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Notional.NotionalBuilder o = (Notional.NotionalBuilder) other;
			
			merger.mergeRosetta(getNotionalStepSchedule(), o.getNotionalStepSchedule(), this::setNotionalStepSchedule);
			merger.mergeRosetta(getNotionalStepParameters(), o.getNotionalStepParameters(), this::setNotionalStepParameters);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Notional _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(notionalStepSchedule, _that.getNotionalStepSchedule())) return false;
			if (!Objects.equals(notionalStepParameters, _that.getNotionalStepParameters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (notionalStepSchedule != null ? notionalStepSchedule.hashCode() : 0);
			_result = 31 * _result + (notionalStepParameters != null ? notionalStepParameters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalBuilder {" +
				"id=" + this.id + ", " +
				"notionalStepSchedule=" + this.notionalStepSchedule + ", " +
				"notionalStepParameters=" + this.notionalStepParameters +
			'}';
		}
	}
}
