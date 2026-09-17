package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.PackageTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that describes what thpe of package this is, e.g. Butterfly.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes what thpe of package this is, e.g. Butterfly.
 *
 */
@RosettaDataType(value="PackageType", builder=PackageType.PackageTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PackageType", model="fpml", builder=PackageType.PackageTypeBuilderImpl.class, version="2.1.1")
public interface PackageType extends RosettaModelObject {

	PackageTypeMeta metaData = new PackageTypeMeta();

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
	String getPackageTypeScheme();

	/*********************** Build Methods  ***********************/
	PackageType build();
	
	PackageType.PackageTypeBuilder toBuilder();
	
	static PackageType.PackageTypeBuilder builder() {
		return new PackageType.PackageTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PackageType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PackageType> getType() {
		return PackageType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("packageTypeScheme"), String.class, getPackageTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PackageTypeBuilder extends PackageType, RosettaModelObjectBuilder {
		PackageType.PackageTypeBuilder setValue(String value);
		PackageType.PackageTypeBuilder setPackageTypeScheme(String packageTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("packageTypeScheme"), String.class, getPackageTypeScheme(), this);
		}
		

		PackageType.PackageTypeBuilder prune();
	}

	/*********************** Immutable Implementation of PackageType  ***********************/
	class PackageTypeImpl implements PackageType {
		private final String value;
		private final String packageTypeScheme;
		
		protected PackageTypeImpl(PackageType.PackageTypeBuilder builder) {
			this.value = builder.getValue();
			this.packageTypeScheme = builder.getPackageTypeScheme();
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
		@RosettaAttribute("packageTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTypeScheme")
		public String getPackageTypeScheme() {
			return packageTypeScheme;
		}
		
		@Override
		public PackageType build() {
			return this;
		}
		
		@Override
		public PackageType.PackageTypeBuilder toBuilder() {
			PackageType.PackageTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PackageType.PackageTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getPackageTypeScheme()).ifPresent(builder::setPackageTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PackageType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(packageTypeScheme, _that.getPackageTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (packageTypeScheme != null ? packageTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PackageType {" +
				"value=" + this.value + ", " +
				"packageTypeScheme=" + this.packageTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of PackageType  ***********************/
	class PackageTypeBuilderImpl implements PackageType.PackageTypeBuilder {
	
		protected String value;
		protected String packageTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("packageTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageTypeScheme")
		public String getPackageTypeScheme() {
			return packageTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public PackageType.PackageTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("packageTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageTypeScheme")
		@Override
		public PackageType.PackageTypeBuilder setPackageTypeScheme(String _packageTypeScheme) {
			this.packageTypeScheme = _packageTypeScheme == null ? null : _packageTypeScheme;
			return this;
		}
		
		@Override
		public PackageType build() {
			return new PackageType.PackageTypeImpl(this);
		}
		
		@Override
		public PackageType.PackageTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PackageType.PackageTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getPackageTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PackageType.PackageTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PackageType.PackageTypeBuilder o = (PackageType.PackageTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getPackageTypeScheme(), o.getPackageTypeScheme(), this::setPackageTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PackageType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(packageTypeScheme, _that.getPackageTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (packageTypeScheme != null ? packageTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PackageTypeBuilder {" +
				"value=" + this.value + ", " +
				"packageTypeScheme=" + this.packageTypeScheme +
			'}';
		}
	}
}
