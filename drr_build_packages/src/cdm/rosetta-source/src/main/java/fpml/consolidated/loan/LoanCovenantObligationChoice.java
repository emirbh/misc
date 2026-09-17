package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanCovenantObligationChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="LoanCovenantObligationChoice", builder=LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationChoice", model="fpml", builder=LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationChoice extends RosettaModelObject {

	LoanCovenantObligationChoiceMeta metaData = new LoanCovenantObligationChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An optional free form text field to further describe the covenant language. This field can be used to house the exact language as depicted in the credit agreement.
	 *
	 */
	String getDescription();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the location of the covenant language within the credit agreement (i.e. specific section, paragraph, subparagraph, etc.). Note: this structure is intended to be used for indicative purposes only.
	 *
	 */
	String getLocation();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationChoice build();
	
	LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder toBuilder();
	
	static LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder builder() {
		return new LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationChoice> getType() {
		return LoanCovenantObligationChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processor.processBasic(path.newSubPath("location"), String.class, getLocation(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationChoiceBuilder extends LoanCovenantObligationChoice, RosettaModelObjectBuilder {
		LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder setDescription(String description);
		LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder setLocation(String location);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processor.processBasic(path.newSubPath("location"), String.class, getLocation(), this);
		}
		

		LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationChoice  ***********************/
	class LoanCovenantObligationChoiceImpl implements LoanCovenantObligationChoice {
		private final String description;
		private final String location;
		
		protected LoanCovenantObligationChoiceImpl(LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder builder) {
			this.description = builder.getDescription();
			this.location = builder.getLocation();
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("location")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("location")
		public String getLocation() {
			return location;
		}
		
		@Override
		public LoanCovenantObligationChoice build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder toBuilder() {
			LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder builder) {
			ofNullable(getDescription()).ifPresent(builder::setDescription);
			ofNullable(getLocation()).ifPresent(builder::setLocation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationChoice _that = getType().cast(o);
		
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(location, _that.getLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (location != null ? location.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationChoice {" +
				"description=" + this.description + ", " +
				"location=" + this.location +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationChoice  ***********************/
	class LoanCovenantObligationChoiceBuilderImpl implements LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder {
	
		protected String description;
		protected String location;
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("location")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("location")
		public String getLocation() {
			return location;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("location")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("location")
		@Override
		public LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder setLocation(String _location) {
			this.location = _location == null ? null : _location;
			return this;
		}
		
		@Override
		public LoanCovenantObligationChoice build() {
			return new LoanCovenantObligationChoice.LoanCovenantObligationChoiceImpl(this);
		}
		
		@Override
		public LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDescription()!=null) return true;
			if (getLocation()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder o = (LoanCovenantObligationChoice.LoanCovenantObligationChoiceBuilder) other;
			
			
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			merger.mergeBasic(getLocation(), o.getLocation(), this::setLocation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationChoice _that = getType().cast(o);
		
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(location, _that.getLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (location != null ? location.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationChoiceBuilder {" +
				"description=" + this.description + ", " +
				"location=" + this.location +
			'}';
		}
	}
}
