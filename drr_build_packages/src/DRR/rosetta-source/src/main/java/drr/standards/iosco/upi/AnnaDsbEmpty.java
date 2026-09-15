package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbEmptyMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbEmpty", builder=AnnaDsbEmpty.AnnaDsbEmptyBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbEmpty", model="drr", builder=AnnaDsbEmpty.AnnaDsbEmptyBuilderImpl.class, version="7.7.0")
public interface AnnaDsbEmpty extends RosettaModelObject {

	AnnaDsbEmptyMeta metaData = new AnnaDsbEmptyMeta();

	/*********************** Getter Methods  ***********************/
	String getEmptyField();

	/*********************** Build Methods  ***********************/
	AnnaDsbEmpty build();
	
	AnnaDsbEmpty.AnnaDsbEmptyBuilder toBuilder();
	
	static AnnaDsbEmpty.AnnaDsbEmptyBuilder builder() {
		return new AnnaDsbEmpty.AnnaDsbEmptyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbEmpty> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbEmpty> getType() {
		return AnnaDsbEmpty.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("emptyField"), String.class, getEmptyField(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbEmptyBuilder extends AnnaDsbEmpty, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder setEmptyField(String emptyField);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("emptyField"), String.class, getEmptyField(), this);
		}
		

		AnnaDsbEmpty.AnnaDsbEmptyBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbEmpty  ***********************/
	class AnnaDsbEmptyImpl implements AnnaDsbEmpty {
		private final String emptyField;
		
		protected AnnaDsbEmptyImpl(AnnaDsbEmpty.AnnaDsbEmptyBuilder builder) {
			this.emptyField = builder.getEmptyField();
		}
		
		@Override
		@RosettaAttribute("emptyField")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("emptyField")
		public String getEmptyField() {
			return emptyField;
		}
		
		@Override
		public AnnaDsbEmpty build() {
			return this;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder toBuilder() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbEmpty.AnnaDsbEmptyBuilder builder) {
			ofNullable(getEmptyField()).ifPresent(builder::setEmptyField);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbEmpty _that = getType().cast(o);
		
			if (!Objects.equals(emptyField, _that.getEmptyField())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (emptyField != null ? emptyField.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbEmpty {" +
				"emptyField=" + this.emptyField +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbEmpty  ***********************/
	class AnnaDsbEmptyBuilderImpl implements AnnaDsbEmpty.AnnaDsbEmptyBuilder {
	
		protected String emptyField;
		
		@Override
		@RosettaAttribute("emptyField")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("emptyField")
		public String getEmptyField() {
			return emptyField;
		}
		
		@RosettaAttribute("emptyField")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("emptyField")
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder setEmptyField(String _emptyField) {
			this.emptyField = _emptyField == null ? null : _emptyField;
			return this;
		}
		
		@Override
		public AnnaDsbEmpty build() {
			return new AnnaDsbEmpty.AnnaDsbEmptyImpl(this);
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEmptyField()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder o = (AnnaDsbEmpty.AnnaDsbEmptyBuilder) other;
			
			
			merger.mergeBasic(getEmptyField(), o.getEmptyField(), this::setEmptyField);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbEmpty _that = getType().cast(o);
		
			if (!Objects.equals(emptyField, _that.getEmptyField())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (emptyField != null ? emptyField.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbEmptyBuilder {" +
				"emptyField=" + this.emptyField +
			'}';
		}
	}
}
