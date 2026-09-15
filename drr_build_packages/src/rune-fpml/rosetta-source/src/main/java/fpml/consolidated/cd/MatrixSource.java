package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.MatrixSourceMeta;
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
@RosettaDataType(value="MatrixSource", builder=MatrixSource.MatrixSourceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MatrixSource", model="fpml", builder=MatrixSource.MatrixSourceBuilderImpl.class, version="2.1.1")
public interface MatrixSource extends RosettaModelObject {

	MatrixSourceMeta metaData = new MatrixSourceMeta();

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
	String getSettledEntityMatrixSourceScheme();

	/*********************** Build Methods  ***********************/
	MatrixSource build();
	
	MatrixSource.MatrixSourceBuilder toBuilder();
	
	static MatrixSource.MatrixSourceBuilder builder() {
		return new MatrixSource.MatrixSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MatrixSource> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MatrixSource> getType() {
		return MatrixSource.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("settledEntityMatrixSourceScheme"), String.class, getSettledEntityMatrixSourceScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MatrixSourceBuilder extends MatrixSource, RosettaModelObjectBuilder {
		MatrixSource.MatrixSourceBuilder setValue(String value);
		MatrixSource.MatrixSourceBuilder setSettledEntityMatrixSourceScheme(String settledEntityMatrixSourceScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("settledEntityMatrixSourceScheme"), String.class, getSettledEntityMatrixSourceScheme(), this);
		}
		

		MatrixSource.MatrixSourceBuilder prune();
	}

	/*********************** Immutable Implementation of MatrixSource  ***********************/
	class MatrixSourceImpl implements MatrixSource {
		private final String value;
		private final String settledEntityMatrixSourceScheme;
		
		protected MatrixSourceImpl(MatrixSource.MatrixSourceBuilder builder) {
			this.value = builder.getValue();
			this.settledEntityMatrixSourceScheme = builder.getSettledEntityMatrixSourceScheme();
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
		@RosettaAttribute("settledEntityMatrixSourceScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settledEntityMatrixSourceScheme")
		public String getSettledEntityMatrixSourceScheme() {
			return settledEntityMatrixSourceScheme;
		}
		
		@Override
		public MatrixSource build() {
			return this;
		}
		
		@Override
		public MatrixSource.MatrixSourceBuilder toBuilder() {
			MatrixSource.MatrixSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MatrixSource.MatrixSourceBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getSettledEntityMatrixSourceScheme()).ifPresent(builder::setSettledEntityMatrixSourceScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MatrixSource _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settledEntityMatrixSourceScheme, _that.getSettledEntityMatrixSourceScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrixSourceScheme != null ? settledEntityMatrixSourceScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MatrixSource {" +
				"value=" + this.value + ", " +
				"settledEntityMatrixSourceScheme=" + this.settledEntityMatrixSourceScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MatrixSource  ***********************/
	class MatrixSourceBuilderImpl implements MatrixSource.MatrixSourceBuilder {
	
		protected String value;
		protected String settledEntityMatrixSourceScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("settledEntityMatrixSourceScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settledEntityMatrixSourceScheme")
		public String getSettledEntityMatrixSourceScheme() {
			return settledEntityMatrixSourceScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public MatrixSource.MatrixSourceBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("settledEntityMatrixSourceScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settledEntityMatrixSourceScheme")
		@Override
		public MatrixSource.MatrixSourceBuilder setSettledEntityMatrixSourceScheme(String _settledEntityMatrixSourceScheme) {
			this.settledEntityMatrixSourceScheme = _settledEntityMatrixSourceScheme == null ? null : _settledEntityMatrixSourceScheme;
			return this;
		}
		
		@Override
		public MatrixSource build() {
			return new MatrixSource.MatrixSourceImpl(this);
		}
		
		@Override
		public MatrixSource.MatrixSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MatrixSource.MatrixSourceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getSettledEntityMatrixSourceScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MatrixSource.MatrixSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MatrixSource.MatrixSourceBuilder o = (MatrixSource.MatrixSourceBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSettledEntityMatrixSourceScheme(), o.getSettledEntityMatrixSourceScheme(), this::setSettledEntityMatrixSourceScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MatrixSource _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settledEntityMatrixSourceScheme, _that.getSettledEntityMatrixSourceScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settledEntityMatrixSourceScheme != null ? settledEntityMatrixSourceScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MatrixSourceBuilder {" +
				"value=" + this.value + ", " +
				"settledEntityMatrixSourceScheme=" + this.settledEntityMatrixSourceScheme +
			'}';
		}
	}
}
