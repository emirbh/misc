package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.ActionTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for ESMA action type.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for ESMA action type.
 *
 */
@RosettaDataType(value="ActionType", builder=ActionType.ActionTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ActionType", model="fpml", builder=ActionType.ActionTypeBuilderImpl.class, version="2.1.1")
public interface ActionType extends RosettaModelObject {

	ActionTypeMeta metaData = new ActionTypeMeta();

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
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The identifier scheme used with this actionType. A unique URI to determine the the type of action.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The identifier scheme used with this actionType. A unique URI to determine the the type of action.
	 *
	 */
	String getActionTypeScheme();

	/*********************** Build Methods  ***********************/
	ActionType build();
	
	ActionType.ActionTypeBuilder toBuilder();
	
	static ActionType.ActionTypeBuilder builder() {
		return new ActionType.ActionTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActionType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ActionType> getType() {
		return ActionType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("actionTypeScheme"), String.class, getActionTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActionTypeBuilder extends ActionType, RosettaModelObjectBuilder {
		ActionType.ActionTypeBuilder setValue(String value);
		ActionType.ActionTypeBuilder setActionTypeScheme(String actionTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("actionTypeScheme"), String.class, getActionTypeScheme(), this);
		}
		

		ActionType.ActionTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ActionType  ***********************/
	class ActionTypeImpl implements ActionType {
		private final String value;
		private final String actionTypeScheme;
		
		protected ActionTypeImpl(ActionType.ActionTypeBuilder builder) {
			this.value = builder.getValue();
			this.actionTypeScheme = builder.getActionTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("actionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionTypeScheme")
		public String getActionTypeScheme() {
			return actionTypeScheme;
		}
		
		@Override
		public ActionType build() {
			return this;
		}
		
		@Override
		public ActionType.ActionTypeBuilder toBuilder() {
			ActionType.ActionTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActionType.ActionTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getActionTypeScheme()).ifPresent(builder::setActionTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(actionTypeScheme, _that.getActionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (actionTypeScheme != null ? actionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActionType {" +
				"value=" + this.value + ", " +
				"actionTypeScheme=" + this.actionTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ActionType  ***********************/
	class ActionTypeBuilderImpl implements ActionType.ActionTypeBuilder {
	
		protected String value;
		protected String actionTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("actionTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionTypeScheme")
		public String getActionTypeScheme() {
			return actionTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ActionType.ActionTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("actionTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionTypeScheme")
		@Override
		public ActionType.ActionTypeBuilder setActionTypeScheme(String _actionTypeScheme) {
			this.actionTypeScheme = _actionTypeScheme == null ? null : _actionTypeScheme;
			return this;
		}
		
		@Override
		public ActionType build() {
			return new ActionType.ActionTypeImpl(this);
		}
		
		@Override
		public ActionType.ActionTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActionType.ActionTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getActionTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActionType.ActionTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActionType.ActionTypeBuilder o = (ActionType.ActionTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getActionTypeScheme(), o.getActionTypeScheme(), this::setActionTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActionType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(actionTypeScheme, _that.getActionTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (actionTypeScheme != null ? actionTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActionTypeBuilder {" +
				"value=" + this.value + ", " +
				"actionTypeScheme=" + this.actionTypeScheme +
			'}';
		}
	}
}
