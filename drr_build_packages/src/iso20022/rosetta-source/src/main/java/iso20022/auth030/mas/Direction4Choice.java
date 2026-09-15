package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.Direction4ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Direction4Choice", builder=Direction4Choice.Direction4ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="Direction4Choice", model="iso20022", builder=Direction4Choice.Direction4ChoiceBuilderImpl.class, version="${project.version}")
public interface Direction4Choice extends RosettaModelObject {

	Direction4ChoiceMeta metaData = new Direction4ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	Direction2 getDrctn();
	OptionParty1Code getCtrPtySd();

	/*********************** Build Methods  ***********************/
	Direction4Choice build();
	
	Direction4Choice.Direction4ChoiceBuilder toBuilder();
	
	static Direction4Choice.Direction4ChoiceBuilder builder() {
		return new Direction4Choice.Direction4ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Direction4Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Direction4Choice> getType() {
		return Direction4Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("drctn"), processor, Direction2.class, getDrctn());
		processor.processBasic(path.newSubPath("ctrPtySd"), OptionParty1Code.class, getCtrPtySd(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Direction4ChoiceBuilder extends Direction4Choice, RosettaModelObjectBuilder {
		Direction2.Direction2Builder getOrCreateDrctn();
		@Override
		Direction2.Direction2Builder getDrctn();
		Direction4Choice.Direction4ChoiceBuilder setDrctn(Direction2 drctn);
		Direction4Choice.Direction4ChoiceBuilder setCtrPtySd(OptionParty1Code ctrPtySd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("drctn"), processor, Direction2.Direction2Builder.class, getDrctn());
			processor.processBasic(path.newSubPath("ctrPtySd"), OptionParty1Code.class, getCtrPtySd(), this);
		}
		

		Direction4Choice.Direction4ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of Direction4Choice  ***********************/
	class Direction4ChoiceImpl implements Direction4Choice {
		private final Direction2 drctn;
		private final OptionParty1Code ctrPtySd;
		
		protected Direction4ChoiceImpl(Direction4Choice.Direction4ChoiceBuilder builder) {
			this.drctn = ofNullable(builder.getDrctn()).map(f->f.build()).orElse(null);
			this.ctrPtySd = builder.getCtrPtySd();
		}
		
		@Override
		@RosettaAttribute("drctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drctn")
		public Direction2 getDrctn() {
			return drctn;
		}
		
		@Override
		@RosettaAttribute("ctrPtySd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrPtySd")
		public OptionParty1Code getCtrPtySd() {
			return ctrPtySd;
		}
		
		@Override
		public Direction4Choice build() {
			return this;
		}
		
		@Override
		public Direction4Choice.Direction4ChoiceBuilder toBuilder() {
			Direction4Choice.Direction4ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Direction4Choice.Direction4ChoiceBuilder builder) {
			ofNullable(getDrctn()).ifPresent(builder::setDrctn);
			ofNullable(getCtrPtySd()).ifPresent(builder::setCtrPtySd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Direction4Choice _that = getType().cast(o);
		
			if (!Objects.equals(drctn, _that.getDrctn())) return false;
			if (!Objects.equals(ctrPtySd, _that.getCtrPtySd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (drctn != null ? drctn.hashCode() : 0);
			_result = 31 * _result + (ctrPtySd != null ? ctrPtySd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Direction4Choice {" +
				"drctn=" + this.drctn + ", " +
				"ctrPtySd=" + this.ctrPtySd +
			'}';
		}
	}

	/*********************** Builder Implementation of Direction4Choice  ***********************/
	class Direction4ChoiceBuilderImpl implements Direction4Choice.Direction4ChoiceBuilder {
	
		protected Direction2.Direction2Builder drctn;
		protected OptionParty1Code ctrPtySd;
		
		@Override
		@RosettaAttribute("drctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("drctn")
		public Direction2.Direction2Builder getDrctn() {
			return drctn;
		}
		
		@Override
		public Direction2.Direction2Builder getOrCreateDrctn() {
			Direction2.Direction2Builder result;
			if (drctn!=null) {
				result = drctn;
			}
			else {
				result = drctn = Direction2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ctrPtySd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrPtySd")
		public OptionParty1Code getCtrPtySd() {
			return ctrPtySd;
		}
		
		@RosettaAttribute("drctn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("drctn")
		@Override
		public Direction4Choice.Direction4ChoiceBuilder setDrctn(Direction2 _drctn) {
			this.drctn = _drctn == null ? null : _drctn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ctrPtySd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctrPtySd")
		@Override
		public Direction4Choice.Direction4ChoiceBuilder setCtrPtySd(OptionParty1Code _ctrPtySd) {
			this.ctrPtySd = _ctrPtySd == null ? null : _ctrPtySd;
			return this;
		}
		
		@Override
		public Direction4Choice build() {
			return new Direction4Choice.Direction4ChoiceImpl(this);
		}
		
		@Override
		public Direction4Choice.Direction4ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Direction4Choice.Direction4ChoiceBuilder prune() {
			if (drctn!=null && !drctn.prune().hasData()) drctn = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDrctn()!=null && getDrctn().hasData()) return true;
			if (getCtrPtySd()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Direction4Choice.Direction4ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Direction4Choice.Direction4ChoiceBuilder o = (Direction4Choice.Direction4ChoiceBuilder) other;
			
			merger.mergeRosetta(getDrctn(), o.getDrctn(), this::setDrctn);
			
			merger.mergeBasic(getCtrPtySd(), o.getCtrPtySd(), this::setCtrPtySd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Direction4Choice _that = getType().cast(o);
		
			if (!Objects.equals(drctn, _that.getDrctn())) return false;
			if (!Objects.equals(ctrPtySd, _that.getCtrPtySd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (drctn != null ? drctn.hashCode() : 0);
			_result = 31 * _result + (ctrPtySd != null ? ctrPtySd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Direction4ChoiceBuilder {" +
				"drctn=" + this.drctn + ", " +
				"ctrPtySd=" + this.ctrPtySd +
			'}';
		}
	}
}
