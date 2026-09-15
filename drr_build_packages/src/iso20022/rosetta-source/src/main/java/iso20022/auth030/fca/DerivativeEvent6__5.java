package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.DerivativeEvent6__5Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to derivative details.
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativeEvent6__5", builder=DerivativeEvent6__5.DerivativeEvent6__5BuilderImpl.class, version="${project.version}")
@RuneDataType(value="DerivativeEvent6__5", model="iso20022", builder=DerivativeEvent6__5.DerivativeEvent6__5BuilderImpl.class, version="${project.version}")
public interface DerivativeEvent6__5 extends RosettaModelObject {

	DerivativeEvent6__5Meta metaData = new DerivativeEvent6__5Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the time stamp of a derivative event.
	 */
	DateAndDateTime2Choice__1 getTmStmp();

	/*********************** Build Methods  ***********************/
	DerivativeEvent6__5 build();
	
	DerivativeEvent6__5.DerivativeEvent6__5Builder toBuilder();
	
	static DerivativeEvent6__5.DerivativeEvent6__5Builder builder() {
		return new DerivativeEvent6__5.DerivativeEvent6__5BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativeEvent6__5> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DerivativeEvent6__5> getType() {
		return DerivativeEvent6__5.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tmStmp"), processor, DateAndDateTime2Choice__1.class, getTmStmp());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativeEvent6__5Builder extends DerivativeEvent6__5, RosettaModelObjectBuilder {
		DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder getOrCreateTmStmp();
		@Override
		DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder getTmStmp();
		DerivativeEvent6__5.DerivativeEvent6__5Builder setTmStmp(DateAndDateTime2Choice__1 tmStmp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tmStmp"), processor, DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder.class, getTmStmp());
		}
		

		DerivativeEvent6__5.DerivativeEvent6__5Builder prune();
	}

	/*********************** Immutable Implementation of DerivativeEvent6__5  ***********************/
	class DerivativeEvent6__5Impl implements DerivativeEvent6__5 {
		private final DateAndDateTime2Choice__1 tmStmp;
		
		protected DerivativeEvent6__5Impl(DerivativeEvent6__5.DerivativeEvent6__5Builder builder) {
			this.tmStmp = ofNullable(builder.getTmStmp()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tmStmp")
		public DateAndDateTime2Choice__1 getTmStmp() {
			return tmStmp;
		}
		
		@Override
		public DerivativeEvent6__5 build() {
			return this;
		}
		
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder toBuilder() {
			DerivativeEvent6__5.DerivativeEvent6__5Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativeEvent6__5.DerivativeEvent6__5Builder builder) {
			ofNullable(getTmStmp()).ifPresent(builder::setTmStmp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeEvent6__5 _that = getType().cast(o);
		
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeEvent6__5 {" +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativeEvent6__5  ***********************/
	class DerivativeEvent6__5BuilderImpl implements DerivativeEvent6__5.DerivativeEvent6__5Builder {
	
		protected DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder tmStmp;
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tmStmp")
		public DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder getTmStmp() {
			return tmStmp;
		}
		
		@Override
		public DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder getOrCreateTmStmp() {
			DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder result;
			if (tmStmp!=null) {
				result = tmStmp;
			}
			else {
				result = tmStmp = DateAndDateTime2Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tmStmp")
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder setTmStmp(DateAndDateTime2Choice__1 _tmStmp) {
			this.tmStmp = _tmStmp == null ? null : _tmStmp.toBuilder();
			return this;
		}
		
		@Override
		public DerivativeEvent6__5 build() {
			return new DerivativeEvent6__5.DerivativeEvent6__5Impl(this);
		}
		
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder prune() {
			if (tmStmp!=null && !tmStmp.prune().hasData()) tmStmp = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTmStmp()!=null && getTmStmp().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeEvent6__5.DerivativeEvent6__5Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativeEvent6__5.DerivativeEvent6__5Builder o = (DerivativeEvent6__5.DerivativeEvent6__5Builder) other;
			
			merger.mergeRosetta(getTmStmp(), o.getTmStmp(), this::setTmStmp);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeEvent6__5 _that = getType().cast(o);
		
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeEvent6__5Builder {" +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}
}
