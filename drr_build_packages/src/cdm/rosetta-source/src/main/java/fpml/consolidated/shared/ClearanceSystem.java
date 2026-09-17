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
import fpml.consolidated.shared.meta.ClearanceSystemMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Unless otherwise specified, the principal clearance system customarily used for settling trades in the relevant underlying.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Unless otherwise specified, the principal clearance system customarily used for settling trades in the relevant underlying.
 *
 */
@RosettaDataType(value="ClearanceSystem", builder=ClearanceSystem.ClearanceSystemBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ClearanceSystem", model="fpml", builder=ClearanceSystem.ClearanceSystemBuilderImpl.class, version="2.1.1")
public interface ClearanceSystem extends RosettaModelObject {

	ClearanceSystemMeta metaData = new ClearanceSystemMeta();

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
	String getClearanceSystemScheme();

	/*********************** Build Methods  ***********************/
	ClearanceSystem build();
	
	ClearanceSystem.ClearanceSystemBuilder toBuilder();
	
	static ClearanceSystem.ClearanceSystemBuilder builder() {
		return new ClearanceSystem.ClearanceSystemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearanceSystem> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearanceSystem> getType() {
		return ClearanceSystem.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("clearanceSystemScheme"), String.class, getClearanceSystemScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearanceSystemBuilder extends ClearanceSystem, RosettaModelObjectBuilder {
		ClearanceSystem.ClearanceSystemBuilder setValue(String value);
		ClearanceSystem.ClearanceSystemBuilder setClearanceSystemScheme(String clearanceSystemScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("clearanceSystemScheme"), String.class, getClearanceSystemScheme(), this);
		}
		

		ClearanceSystem.ClearanceSystemBuilder prune();
	}

	/*********************** Immutable Implementation of ClearanceSystem  ***********************/
	class ClearanceSystemImpl implements ClearanceSystem {
		private final String value;
		private final String clearanceSystemScheme;
		
		protected ClearanceSystemImpl(ClearanceSystem.ClearanceSystemBuilder builder) {
			this.value = builder.getValue();
			this.clearanceSystemScheme = builder.getClearanceSystemScheme();
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
		@RosettaAttribute("clearanceSystemScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearanceSystemScheme")
		public String getClearanceSystemScheme() {
			return clearanceSystemScheme;
		}
		
		@Override
		public ClearanceSystem build() {
			return this;
		}
		
		@Override
		public ClearanceSystem.ClearanceSystemBuilder toBuilder() {
			ClearanceSystem.ClearanceSystemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearanceSystem.ClearanceSystemBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getClearanceSystemScheme()).ifPresent(builder::setClearanceSystemScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearanceSystem _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(clearanceSystemScheme, _that.getClearanceSystemScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (clearanceSystemScheme != null ? clearanceSystemScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearanceSystem {" +
				"value=" + this.value + ", " +
				"clearanceSystemScheme=" + this.clearanceSystemScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearanceSystem  ***********************/
	class ClearanceSystemBuilderImpl implements ClearanceSystem.ClearanceSystemBuilder {
	
		protected String value;
		protected String clearanceSystemScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("clearanceSystemScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearanceSystemScheme")
		public String getClearanceSystemScheme() {
			return clearanceSystemScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ClearanceSystem.ClearanceSystemBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("clearanceSystemScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearanceSystemScheme")
		@Override
		public ClearanceSystem.ClearanceSystemBuilder setClearanceSystemScheme(String _clearanceSystemScheme) {
			this.clearanceSystemScheme = _clearanceSystemScheme == null ? null : _clearanceSystemScheme;
			return this;
		}
		
		@Override
		public ClearanceSystem build() {
			return new ClearanceSystem.ClearanceSystemImpl(this);
		}
		
		@Override
		public ClearanceSystem.ClearanceSystemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearanceSystem.ClearanceSystemBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getClearanceSystemScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearanceSystem.ClearanceSystemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearanceSystem.ClearanceSystemBuilder o = (ClearanceSystem.ClearanceSystemBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getClearanceSystemScheme(), o.getClearanceSystemScheme(), this::setClearanceSystemScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearanceSystem _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(clearanceSystemScheme, _that.getClearanceSystemScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (clearanceSystemScheme != null ? clearanceSystemScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearanceSystemBuilder {" +
				"value=" + this.value + ", " +
				"clearanceSystemScheme=" + this.clearanceSystemScheme +
			'}';
		}
	}
}
