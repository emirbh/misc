package fpml.consolidated.asset;

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
import fpml.consolidated.asset.meta.LienMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type describing the liens associated with a loan facility.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the liens associated with a loan facility.
 *
 */
@RosettaDataType(value="Lien", builder=Lien.LienBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Lien", model="fpml", builder=Lien.LienBuilderImpl.class, version="2.1.1")
public interface Lien extends RosettaModelObject {

	LienMeta metaData = new LienMeta();

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
	String getLienScheme();

	/*********************** Build Methods  ***********************/
	Lien build();
	
	Lien.LienBuilder toBuilder();
	
	static Lien.LienBuilder builder() {
		return new Lien.LienBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Lien> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Lien> getType() {
		return Lien.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("lienScheme"), String.class, getLienScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LienBuilder extends Lien, RosettaModelObjectBuilder {
		Lien.LienBuilder setValue(String value);
		Lien.LienBuilder setLienScheme(String lienScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("lienScheme"), String.class, getLienScheme(), this);
		}
		

		Lien.LienBuilder prune();
	}

	/*********************** Immutable Implementation of Lien  ***********************/
	class LienImpl implements Lien {
		private final String value;
		private final String lienScheme;
		
		protected LienImpl(Lien.LienBuilder builder) {
			this.value = builder.getValue();
			this.lienScheme = builder.getLienScheme();
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
		@RosettaAttribute("lienScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lienScheme")
		public String getLienScheme() {
			return lienScheme;
		}
		
		@Override
		public Lien build() {
			return this;
		}
		
		@Override
		public Lien.LienBuilder toBuilder() {
			Lien.LienBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Lien.LienBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLienScheme()).ifPresent(builder::setLienScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lien _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lienScheme, _that.getLienScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lienScheme != null ? lienScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Lien {" +
				"value=" + this.value + ", " +
				"lienScheme=" + this.lienScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of Lien  ***********************/
	class LienBuilderImpl implements Lien.LienBuilder {
	
		protected String value;
		protected String lienScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("lienScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lienScheme")
		public String getLienScheme() {
			return lienScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public Lien.LienBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("lienScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lienScheme")
		@Override
		public Lien.LienBuilder setLienScheme(String _lienScheme) {
			this.lienScheme = _lienScheme == null ? null : _lienScheme;
			return this;
		}
		
		@Override
		public Lien build() {
			return new Lien.LienImpl(this);
		}
		
		@Override
		public Lien.LienBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lien.LienBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLienScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lien.LienBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Lien.LienBuilder o = (Lien.LienBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLienScheme(), o.getLienScheme(), this::setLienScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lien _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(lienScheme, _that.getLienScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (lienScheme != null ? lienScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LienBuilder {" +
				"value=" + this.value + ", " +
				"lienScheme=" + this.lienScheme +
			'}';
		}
	}
}
