package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.FloatingRateIdentification8Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identifies various types of floating rates.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRateIdentification8Choice__1", builder=FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FloatingRateIdentification8Choice__1", model="iso20022", builder=FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1BuilderImpl.class, version="${project.version}")
public interface FloatingRateIdentification8Choice__1 extends RosettaModelObject {

	FloatingRateIdentification8Choice__1Meta metaData = new FloatingRateIdentification8Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * List of floating rate curves.
	 */
	FloatingRateIndex1Code getCd();

	/*********************** Build Methods  ***********************/
	FloatingRateIdentification8Choice__1 build();
	
	FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder toBuilder();
	
	static FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder builder() {
		return new FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIdentification8Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIdentification8Choice__1> getType() {
		return FloatingRateIdentification8Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cd"), FloatingRateIndex1Code.class, getCd(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIdentification8Choice__1Builder extends FloatingRateIdentification8Choice__1, RosettaModelObjectBuilder {
		FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder setCd(FloatingRateIndex1Code cd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cd"), FloatingRateIndex1Code.class, getCd(), this);
		}
		

		FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIdentification8Choice__1  ***********************/
	class FloatingRateIdentification8Choice__1Impl implements FloatingRateIdentification8Choice__1 {
		private final FloatingRateIndex1Code cd;
		
		protected FloatingRateIdentification8Choice__1Impl(FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder builder) {
			this.cd = builder.getCd();
		}
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public FloatingRateIndex1Code getCd() {
			return cd;
		}
		
		@Override
		public FloatingRateIdentification8Choice__1 build() {
			return this;
		}
		
		@Override
		public FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder toBuilder() {
			FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder builder) {
			ofNullable(getCd()).ifPresent(builder::setCd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIdentification8Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIdentification8Choice__1 {" +
				"cd=" + this.cd +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIdentification8Choice__1  ***********************/
	class FloatingRateIdentification8Choice__1BuilderImpl implements FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder {
	
		protected FloatingRateIndex1Code cd;
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public FloatingRateIndex1Code getCd() {
			return cd;
		}
		
		@RosettaAttribute("cd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cd")
		@Override
		public FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder setCd(FloatingRateIndex1Code _cd) {
			this.cd = _cd == null ? null : _cd;
			return this;
		}
		
		@Override
		public FloatingRateIdentification8Choice__1 build() {
			return new FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Impl(this);
		}
		
		@Override
		public FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCd()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder o = (FloatingRateIdentification8Choice__1.FloatingRateIdentification8Choice__1Builder) other;
			
			
			merger.mergeBasic(getCd(), o.getCd(), this::setCd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIdentification8Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIdentification8Choice__1Builder {" +
				"cd=" + this.cd +
			'}';
		}
	}
}
