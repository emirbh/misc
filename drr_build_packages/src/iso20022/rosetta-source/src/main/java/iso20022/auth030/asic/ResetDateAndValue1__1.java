package iso20022.auth030.asic;

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
import com.rosetta.model.lib.records.Date;
import iso20022.auth030.asic.meta.ResetDateAndValue1__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ResetDateAndValue1__1", builder=ResetDateAndValue1__1.ResetDateAndValue1__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ResetDateAndValue1__1", model="iso20022", builder=ResetDateAndValue1__1.ResetDateAndValue1__1BuilderImpl.class, version="${project.version}")
public interface ResetDateAndValue1__1 extends RosettaModelObject {

	ResetDateAndValue1__1Meta metaData = new ResetDateAndValue1__1Meta();

	/*********************** Getter Methods  ***********************/
	Date getDt();

	/*********************** Build Methods  ***********************/
	ResetDateAndValue1__1 build();
	
	ResetDateAndValue1__1.ResetDateAndValue1__1Builder toBuilder();
	
	static ResetDateAndValue1__1.ResetDateAndValue1__1Builder builder() {
		return new ResetDateAndValue1__1.ResetDateAndValue1__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResetDateAndValue1__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ResetDateAndValue1__1> getType() {
		return ResetDateAndValue1__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dt"), Date.class, getDt(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResetDateAndValue1__1Builder extends ResetDateAndValue1__1, RosettaModelObjectBuilder {
		ResetDateAndValue1__1.ResetDateAndValue1__1Builder setDt(Date dt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dt"), Date.class, getDt(), this);
		}
		

		ResetDateAndValue1__1.ResetDateAndValue1__1Builder prune();
	}

	/*********************** Immutable Implementation of ResetDateAndValue1__1  ***********************/
	class ResetDateAndValue1__1Impl implements ResetDateAndValue1__1 {
		private final Date dt;
		
		protected ResetDateAndValue1__1Impl(ResetDateAndValue1__1.ResetDateAndValue1__1Builder builder) {
			this.dt = builder.getDt();
		}
		
		@Override
		@RosettaAttribute("dt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dt")
		public Date getDt() {
			return dt;
		}
		
		@Override
		public ResetDateAndValue1__1 build() {
			return this;
		}
		
		@Override
		public ResetDateAndValue1__1.ResetDateAndValue1__1Builder toBuilder() {
			ResetDateAndValue1__1.ResetDateAndValue1__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetDateAndValue1__1.ResetDateAndValue1__1Builder builder) {
			ofNullable(getDt()).ifPresent(builder::setDt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetDateAndValue1__1 _that = getType().cast(o);
		
			if (!Objects.equals(dt, _that.getDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dt != null ? dt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetDateAndValue1__1 {" +
				"dt=" + this.dt +
			'}';
		}
	}

	/*********************** Builder Implementation of ResetDateAndValue1__1  ***********************/
	class ResetDateAndValue1__1BuilderImpl implements ResetDateAndValue1__1.ResetDateAndValue1__1Builder {
	
		protected Date dt;
		
		@Override
		@RosettaAttribute("dt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dt")
		public Date getDt() {
			return dt;
		}
		
		@RosettaAttribute("dt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dt")
		@Override
		public ResetDateAndValue1__1.ResetDateAndValue1__1Builder setDt(Date _dt) {
			this.dt = _dt == null ? null : _dt;
			return this;
		}
		
		@Override
		public ResetDateAndValue1__1 build() {
			return new ResetDateAndValue1__1.ResetDateAndValue1__1Impl(this);
		}
		
		@Override
		public ResetDateAndValue1__1.ResetDateAndValue1__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetDateAndValue1__1.ResetDateAndValue1__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDt()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetDateAndValue1__1.ResetDateAndValue1__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResetDateAndValue1__1.ResetDateAndValue1__1Builder o = (ResetDateAndValue1__1.ResetDateAndValue1__1Builder) other;
			
			
			merger.mergeBasic(getDt(), o.getDt(), this::setDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetDateAndValue1__1 _that = getType().cast(o);
		
			if (!Objects.equals(dt, _that.getDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dt != null ? dt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetDateAndValue1__1Builder {" +
				"dt=" + this.dt +
			'}';
		}
	}
}
