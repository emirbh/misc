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
import fpml.consolidated.shared.meta.MainPublicationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type to define the main publication source.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type to define the main publication source.
 *
 */
@RosettaDataType(value="MainPublication", builder=MainPublication.MainPublicationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MainPublication", model="fpml", builder=MainPublication.MainPublicationBuilderImpl.class, version="2.1.1")
public interface MainPublication extends RosettaModelObject {

	MainPublicationMeta metaData = new MainPublicationMeta();

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
	String getMainPublicationScheme();

	/*********************** Build Methods  ***********************/
	MainPublication build();
	
	MainPublication.MainPublicationBuilder toBuilder();
	
	static MainPublication.MainPublicationBuilder builder() {
		return new MainPublication.MainPublicationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MainPublication> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MainPublication> getType() {
		return MainPublication.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("mainPublicationScheme"), String.class, getMainPublicationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MainPublicationBuilder extends MainPublication, RosettaModelObjectBuilder {
		MainPublication.MainPublicationBuilder setValue(String value);
		MainPublication.MainPublicationBuilder setMainPublicationScheme(String mainPublicationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("mainPublicationScheme"), String.class, getMainPublicationScheme(), this);
		}
		

		MainPublication.MainPublicationBuilder prune();
	}

	/*********************** Immutable Implementation of MainPublication  ***********************/
	class MainPublicationImpl implements MainPublication {
		private final String value;
		private final String mainPublicationScheme;
		
		protected MainPublicationImpl(MainPublication.MainPublicationBuilder builder) {
			this.value = builder.getValue();
			this.mainPublicationScheme = builder.getMainPublicationScheme();
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
		@RosettaAttribute("mainPublicationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mainPublicationScheme")
		public String getMainPublicationScheme() {
			return mainPublicationScheme;
		}
		
		@Override
		public MainPublication build() {
			return this;
		}
		
		@Override
		public MainPublication.MainPublicationBuilder toBuilder() {
			MainPublication.MainPublicationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MainPublication.MainPublicationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMainPublicationScheme()).ifPresent(builder::setMainPublicationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MainPublication _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(mainPublicationScheme, _that.getMainPublicationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (mainPublicationScheme != null ? mainPublicationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MainPublication {" +
				"value=" + this.value + ", " +
				"mainPublicationScheme=" + this.mainPublicationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MainPublication  ***********************/
	class MainPublicationBuilderImpl implements MainPublication.MainPublicationBuilder {
	
		protected String value;
		protected String mainPublicationScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("mainPublicationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mainPublicationScheme")
		public String getMainPublicationScheme() {
			return mainPublicationScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public MainPublication.MainPublicationBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("mainPublicationScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mainPublicationScheme")
		@Override
		public MainPublication.MainPublicationBuilder setMainPublicationScheme(String _mainPublicationScheme) {
			this.mainPublicationScheme = _mainPublicationScheme == null ? null : _mainPublicationScheme;
			return this;
		}
		
		@Override
		public MainPublication build() {
			return new MainPublication.MainPublicationImpl(this);
		}
		
		@Override
		public MainPublication.MainPublicationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MainPublication.MainPublicationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMainPublicationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MainPublication.MainPublicationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MainPublication.MainPublicationBuilder o = (MainPublication.MainPublicationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMainPublicationScheme(), o.getMainPublicationScheme(), this::setMainPublicationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MainPublication _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(mainPublicationScheme, _that.getMainPublicationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (mainPublicationScheme != null ? mainPublicationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MainPublicationBuilder {" +
				"value=" + this.value + ", " +
				"mainPublicationScheme=" + this.mainPublicationScheme +
			'}';
		}
	}
}
