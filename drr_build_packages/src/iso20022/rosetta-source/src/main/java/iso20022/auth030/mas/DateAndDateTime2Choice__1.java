package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.DateAndDateTime2Choice__1Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DateAndDateTime2Choice__1", builder=DateAndDateTime2Choice__1.DateAndDateTime2Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="DateAndDateTime2Choice__1", model="iso20022", builder=DateAndDateTime2Choice__1.DateAndDateTime2Choice__1BuilderImpl.class, version="${project.version}")
public interface DateAndDateTime2Choice__1 extends RosettaModelObject {

	DateAndDateTime2Choice__1Meta metaData = new DateAndDateTime2Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	ZonedDateTime getDtTm();

	/*********************** Build Methods  ***********************/
	DateAndDateTime2Choice__1 build();
	
	DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder toBuilder();
	
	static DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder builder() {
		return new DateAndDateTime2Choice__1.DateAndDateTime2Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DateAndDateTime2Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DateAndDateTime2Choice__1> getType() {
		return DateAndDateTime2Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dtTm"), ZonedDateTime.class, getDtTm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DateAndDateTime2Choice__1Builder extends DateAndDateTime2Choice__1, RosettaModelObjectBuilder {
		DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder setDtTm(ZonedDateTime dtTm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("dtTm"), ZonedDateTime.class, getDtTm(), this);
		}
		

		DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of DateAndDateTime2Choice__1  ***********************/
	class DateAndDateTime2Choice__1Impl implements DateAndDateTime2Choice__1 {
		private final ZonedDateTime dtTm;
		
		protected DateAndDateTime2Choice__1Impl(DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder builder) {
			this.dtTm = builder.getDtTm();
		}
		
		@Override
		@RosettaAttribute("dtTm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dtTm")
		public ZonedDateTime getDtTm() {
			return dtTm;
		}
		
		@Override
		public DateAndDateTime2Choice__1 build() {
			return this;
		}
		
		@Override
		public DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder toBuilder() {
			DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder builder) {
			ofNullable(getDtTm()).ifPresent(builder::setDtTm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateAndDateTime2Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(dtTm, _that.getDtTm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dtTm != null ? dtTm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateAndDateTime2Choice__1 {" +
				"dtTm=" + this.dtTm +
			'}';
		}
	}

	/*********************** Builder Implementation of DateAndDateTime2Choice__1  ***********************/
	class DateAndDateTime2Choice__1BuilderImpl implements DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder {
	
		protected ZonedDateTime dtTm;
		
		@Override
		@RosettaAttribute("dtTm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dtTm")
		public ZonedDateTime getDtTm() {
			return dtTm;
		}
		
		@RosettaAttribute("dtTm")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dtTm")
		@Override
		public DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder setDtTm(ZonedDateTime _dtTm) {
			this.dtTm = _dtTm == null ? null : _dtTm;
			return this;
		}
		
		@Override
		public DateAndDateTime2Choice__1 build() {
			return new DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Impl(this);
		}
		
		@Override
		public DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDtTm()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder o = (DateAndDateTime2Choice__1.DateAndDateTime2Choice__1Builder) other;
			
			
			merger.mergeBasic(getDtTm(), o.getDtTm(), this::setDtTm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DateAndDateTime2Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(dtTm, _that.getDtTm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dtTm != null ? dtTm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DateAndDateTime2Choice__1Builder {" +
				"dtTm=" + this.dtTm +
			'}';
		}
	}
}
